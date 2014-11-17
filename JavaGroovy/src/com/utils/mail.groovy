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

	//def required_fields_map = [to_username : 1 , from_username : 2 , subject : 3 ]

	public mailSend () {
		print "Inside mail class -> mailsend ${to_username}"
		try {
			
			to_username ?: 'avnit.bambah@nb.com'
			from_username ?: 'avnit.bambah@nb.com'
			subject ?: 'default subject , define subject in your code . !!!'
		
			//call Ant email script
			def ant = new AntBuilder()
			ant.mail(mailhost:"${mailhost}", messagemimetype:'text/html',
					 subject:"${subject}"){
				from(address:"${from_username}")
				to(address:"${to_username}")
				message(writer)
				
			}
		}
		catch ( Exception ex )
		{
			System.out.println(ex.toString())
		}

	}

	public mailSendwithAttachment () {
		
		def ant = new AntBuilder()
		ant.mail(mailhost:"${mailhost}", messagemimetype:'text/html',
				 subject:"${subject}"){
			from(address:"${from_username}")
			to(address:"${to_username}")
			message(writer)
		
			attachments(){
				fileset(dir:"${repoDirPath}"){
					include(name:"<<file>>")
				}
			}
		}

	}

	public mailtoNotifyASD () {
		subject = "##UREGENT##" + subject
		mailsend()
	}
}
