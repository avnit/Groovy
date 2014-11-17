package com.test

import java.lang.util.*

import java.lang.sql.*
import static java.lang.Math.*

import javax.swing.ImageIcon
import java.awt.BorderLayout as BL
import java.awt.GridLayout
import groovy.swing.SwingBuilder
import groovy.json.JsonSlurper

import static Calendar.getInstance as now
import static java.lang.Integer.*
import static Boolean.False as F
import com.swingbuilder.extension.Model
import com.swingbuilder.extension.RateView
import com.swingbuilder.extension.ValueView
import com.utils.*

public class TestClass {
	public static void main(String[] args) {
		try {
			println "starting at " + now().time

            Date now = new Date()
/*			Date then = now + 100
			println then
			println cos(456.789).toString()
			String S = 'this is the string'

			println  S[0..9]  //inclusive
			println S[0..1, 4..8, 9..-1]

			def x = 2
			def y = 9
			//assert 287 ==  (x + y) * ( x * y )

			// println sin(123.456) * cos(456.789).toString()

			def count = 0
			def swingbuilder = new SwingBuilder().edt {
				frame(title:'Avnit Application', size:[1080, 900], show: true) {
					borderLayout()
					textlabel = label(text:"Started at " + now.toString() , constraints: BL.NORTH)
					button(text:'Click Me',
					actionPerformed: {count++; textlabel.text = "Clicked ${count} time(s)."; println "clicked"},
					constraints:BL.SOUTH)
				}
			}
*/
			
			def swing = new SwingBuilder()
			def model = new Model()
			
			def frame = swing.frame(title: "Groovy SwingBuilder MVC Demo", layout: new GridLayout(3, 4), size: [100, 500]) {
			
					label("currency")
					label("rate")
					label("value")
			
					for (c in Model.CURRENCY) {
						label(c)
						widget(new RateView(), model: model, currency: c,
								 action: swing.action(closure: { event ->
										event.source.model.setRate(event.source.currency, event.source.text.toDouble());
								  }))
						widget(new ValueView(), model: model, currency: c, action: swing.action(closure: {event ->
										event.source.model.setValue(event.source.currency, event.source.text.toDouble());
								  }))
					}
				}
			
			frame.show()
			model.initialize([1.0, 0.83, 0.56]);
			
			
			
			
	//test mail		
	/*		def m =  new mail()
			m.from_username = "avnit.bambah@nb.com"
			m.to_username = "avnit.bambah@nb.com"
			m.mailSend();
			*/

		}
		catch ( Exception Ex )
		{
			System.out.println(Ex.toString())
		}


	}


}
