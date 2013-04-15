import javax.swing.ImageIcon
import java.awt.BorderLayout as BL
import groovy.swing.SwingBuilder
import groovy.json.JsonSlurper

class RunStartUp {
	/*
	 * testing if i can get the google api to get the json object 
	 * next step is take this json object and call the parser class on this object.
	 * finally make it a webservice and call it in my webpage . 
	 */
	 class params {
	 	String name , 
	 	String value
	 }
	static main(String[] args) {
           
		def base = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=avnit";
		// def base = "https://ajax.googleapis.com/ajax/sevices/search/web?";
		def param = [
			new params (name: "v" ,value :'1.0'),
			new params (name: "q" , value :'Avnit%20Bambah')
			// new params (name:"q" , value : args[0]) 
			// need to get search variable from command line 
			];
		def param_string = '';
			param.each{
				param_string = "$param.name=$param.value&";
			}
		def finalurl = "$base$param_string";
		print finalurl;
		base.plus(param);
		print base.plus(param);

		//println base.toURL().text;
		def jsonObject = base.toURL().text;

		def slurper = new JsonSlurper()
		def result = slurper.parseText(jsonObject);

		println result.toString();
		def urls = result.responseData.results.url;
		for (int i=0 ; i < 5 ; i++) {
			println urls[i];
		}
        

		// println result.responseData.results.url;

	}

}
