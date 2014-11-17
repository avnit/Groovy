package com.batch
import com.utils.*


class HYStatReport {

	// call the database  for connection
	public static void main(String[] args) {
		try
		{

			def getdata = new DatabaseConnection()
			getdata.username = "mdm_rw"
			getdata.password = 'curd0nly'
			getdata.domainName = 'pipwsql008a//sfrm504'
			getdata.servername = 'pipwsql008a//sfrm504'
			getdata.query = "exec DM_Frontoffice..spRptHYStatReport ? , ? "
			getdata.valuetobind = [ 1 : "null", 2:"null"]

			def final_data = getdata.runSql()





			//create an object for mail
			def m =  new mail()
			m.from_username = "avnit.bambah@nb.com"
			m.to_username = "avnit.bambah@nb.com"
			m.subject = convertdata(final_data)
			m.mailSend();

			//Error email to ASD
		}
		catch (Exception ex )
		{
			def m =  new mail()
			m.from_username = "avnit.bambah@nb.com"
			m.to_username = "avnit.bambah@nb.com"
			m.subject = ex.toString()
			m.mailtoNotifyASD();
			//print ex.to_string();
		}
	}
	public convertdata (def data )
	{
		//add formating data here
		def  output = '''
       
'''
		output += data
		return output
	}

}
