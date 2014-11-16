package com.utils;

import groovy.sql.Sql;

public class DatabaseConnection {
	def servername
	def domainName
	def username
	def password

 def s = Sql.newInstance(servername,username , password , 'net.sourceforge.jtds.jdbc.Driver' );
   
  
     
	 
	// s =  Sql.newInstance()


	//sql = Sql.newInstance( 'jdbc:jtds:sqlserver://serverName/dbName-CLASS;domain=domainName', 'username', 'password', 'net.sourceforge.jtds.jdbc.Driver' )
	//sql.eachRow( 'select * from tableName' ) { println "$it.id -- ${it.firstName} --" }



}

