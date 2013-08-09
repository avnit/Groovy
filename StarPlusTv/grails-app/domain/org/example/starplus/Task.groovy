package org.example.starplus

class Task {
      String summary
	  String details
	  Date dateCreated
      Date deadline
	  Long timespent = 10L
	  
	  static hasMany = [ tags : Tag]
	  
    static constraints = {
		summary blank: false , unique:true 
		details blank: true
		dateCreated nullable : true 
		timespent nullable : false , min 0L
		
    }
}
