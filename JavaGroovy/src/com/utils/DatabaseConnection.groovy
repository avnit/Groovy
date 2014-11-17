package com.utils;

import java.sql.Connection
import java.sql.DriverManager
import javax.sql.DataSource
import groovy.sql.Sql

public class DatabaseConnection {

	def servername
	def port
	def domainName
	def username
	def password
	def query
	def valuetobind

	public runSql() {

		try {
			
             //define the driver and connection 
			def driver = Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://$servername:$port", username, password);


			Sql sql = new Sql(conn)
		

			query = "" // initialize the query string
			param_count = 0      // Number of placeholders needed for parameters to query
			pattern = /\?/ // pattern to look for to find number of parameters

			// number of bind variables to satisfy is obtained by number of ? seen in the query
			query.eachMatch(pattern) { param_count++ }
			println '-.' * 40
			println "query is ${query}"

			println "Output is:"
			println '=' * 80
			def count = 0  // row count
			def final_string = ''
			paramlist = []
			if (valuetobind != "none")
				1.upto(param_count) { paramlist << valuetobind }
			sql.eachRow(query, paramlist) { row ->
				count++; // increment number of rows seen so far
				//println "$count. ${row.name}" // print out the column name
				recstr = ""  // initialize the string that represents row
				meta = row.getMetaData() // get metadata about the row

				for (col in 0..<meta.columnCount) {
					// record is stored in a string called recstr
					if (recstr == "") {
						recstr = row[col]
					}
					else {
						recstr += "," + row[col]
					}
				}
				final_string +=  recstr + "/n"
				//outFile.append(recstr + "\n")
			}
			//	}
			conn.close()
		} catch(Exception e) {
			print e.toString()
		}
		finally {
			return recstr
		}
	}

}





