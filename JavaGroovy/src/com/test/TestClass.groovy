package com.test

import java.lang.util.*

import java.lang.sql.*
import static java.lang.Math.*

import javax.swing.ImageIcon
import java.awt.BorderLayout as BL
import groovy.swing.SwingBuilder
import groovy.json.JsonSlurper

import static Calendar.getInstance as now
import static java.lang.Integer.*
import static Boolean.False as F
import com.utils.*
import com.utils.mail

public class TestClass {
	public static void main(String[] args) {
		try {
			println "starting at " + now().time

			Date now = new Date()
			Date then = now + 100
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

			def m =  new mail()
			m.from_username = "avnit.bambah@nb.com"
			m.to_username = "avnit.bambah@nb.com"
			m.mailSend();

		}
		catch ( Exception Ex )
		{
			System.out.println(Ex.toString())
		}


	}


}
