
import javax.swing.ImageIcon 
import java.awt.BorderLayout as BL
import groovy.swing.SwingBuilder 

class RunStartUp {
/*
 * testing if i can get the google api to get the json object 
 * next step is take this json object and call the parser class on this object.
 * finally make it a webservice and call it in my webpage . 
 */
    static main(args) {
        
    def base = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=riccantu";
    def param = [v:'1.0',
                 q:'Text to ',
                 z:'case'];
    
    //println base.toURL().text;
    def jsonObject = base.toURL().text;
    
    println jsonObject;
   
    }

}