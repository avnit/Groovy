package com.utils

import groovy.transform.*
//@ToString
//@EqualsAndHashCode
@Canonical
 
class mail {
	def to_username
	def from_username
	def mailhost = 'mailhost.nb.com'
	def AntbuildPath
	def subject
	def cc_username

	def required_fileds_map = [to_username : 1 , from_username : 2 , subject : 3 ]

	public mailSend () {
		try {
			required_fields_map.each {
			//	${it.key}.value ?: 'avnit.bambah@nb.com';  --alternative 
				if (${it.key}.size() > 1 )
				{
					print "Found good  username [${it.key}]"
				}
				else
				{
					print "Zero byte email address found"
				}

			}


		}
		catch ( Exception ex )
		{
			System.out.println(ex.stackTrace())
		}

	}

	public mailSendwithAttachment () {

	}

	public mailtoNotifyASD () {
		subject = "##UREGENT##" + subject
	}
}
