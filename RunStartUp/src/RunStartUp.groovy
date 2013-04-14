

import javax.swing.ImageIcon 
import java.awt.BorderLayout as BL
import groovy.swing.SwingBuilder 

class RunStartUp {
/*
 * testing if i can do a multiplication table in Java with no issues. 
 */
    static main(args) {
        
    def base = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=avnit";
    def param = [v:'1.0',
                 q:'Text to ',
                 z:'case'];
    
    println base.toURL().text;
    
    
   
    }

}