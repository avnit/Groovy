/**
 * Created by avnitbambah on 11/24/14.
 */

import groovy.sql.Sql
public class databaseConnector
{
    def serverName
    def databaseName
    def instance
    def port
    def username
    def password

    public  static  void connect() {
        Sql s = new Sql()
        s.newInstance()

    }
}