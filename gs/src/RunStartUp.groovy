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
     
         String name 
         String value
     
    static main(String[] args) {
           
        def base = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=avnit";
        // def base = "https://ajax.googleapis.com/ajax/sevices/search/web?";
        def param = [
            new RunStartUp (name: "v" ,value :'1.0'),
         //   new RunStartUp (name: "q" , value :'Avnit%20Bambah'),
			new RunStartUp (name: "q" , value :args[0]),
        //    new params (name:"q" , value : args[0]) 
            // need to get search variable from command line 
            ];
        def param_string = '';
            param.each{
                param_string = "$param.name=$param.value&";
            }
        def finalurl = "$base$param_string";
        println finalurl;
        base.plus(param);
        println base.plus(param);

        //println base.toURL().text;
        def jsonObject = base.toURL().text;

        def slurper = new JsonSlurper()
        def result = slurper.parseText(jsonObject);

        println result.toString();
        
        def urls = result.responseData.results.url;
       def content =  result.responseData.results.content
	   def j =0;
	    result.responseData.results.content.each { 
			println content[j] 
			j++;
			};
        for (int i=0 ; i < 5 ; i++) {
            println urls[i] ;
            println content[i];
        }
        

         

    }

}