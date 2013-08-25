import javax.swing.ImageIcon
import java.awt.BorderLayout as BL
import groovy.swing.SwingBuilder
import groovy.json.JsonSlurper

import static Calendar.getInstance as now 
import static java.lang.Integer.*
import static Boolean.False as F


import static java.lang.Math.*

class RunStartUp {
	/*
	 * testing if i can get the google api to get the json object 
	 * next step is take this json object and call the parser class on this object.
	 * finally make it a web service and call it in my webpage . 
	 */

	String name
	String value

	static main(String[] args) {
		println "starting at " + now().time
		println sin(123.456) * cos(456.789)
		//  def base = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=avnit";
		def base = "https://ajax.googleapis.com/ajax/services/search/web?";
		def param = [
			new RunStartUp (name: "v" ,value :'1.0'),
			new RunStartUp (name: "q" , value :'Avnit'),
			//    new RunStartUp (name: "q" , value :args[0])
			//    new RunstartUp (name:"q" , value : args[0])
			// need to get search variable from command line
		];
		def param_string = '';
		param.each{
			param_string =  param_string +  "${it.name}=${it.value}&";
		}
		def finalurl = "$base$param_string";
		println finalurl;
		println finalurl.toURL();
		println finalurl.toURL().text;
		println "Ending at " + now().time
		def jsonObject = finalurl.toURL().text;

		def slurper = new JsonSlurper()
		def result = slurper.parseText(jsonObject);

		println result.toString();

		def urls = result.responseData.results.url;
		def content =  result.responseData.results.content
		def j =0;
		result.responseData.results.content.each {
			println content[j]
			println "FINISHED DATA LOADING >>>>>>>>TEXTING <<<<<<<<<<<"
			j++;
		};
		for (int i=0 ; i < 15 ; i++) {
			println urls[i] ;
			println content[i];
		}


	}

}