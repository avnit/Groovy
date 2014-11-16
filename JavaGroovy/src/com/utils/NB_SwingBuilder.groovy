package com.utils
import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL


class NB_SwingBuilder {
	
	
	def count = 0
	def swingbuilder = new SwingBuilder().edt {
	  frame(title:'Frame', size:[300,300], show: true) {
		borderLayout()
		textlabel = label(text:"Click the button!", constraints: BL.NORTH)
		button(text:'Click Me',
			 actionPerformed: {count++; textlabel.text = "Clicked ${count} time(s)."; println "clicked"},
			 constraints:BL.SOUTH)
	  }
	}

}
