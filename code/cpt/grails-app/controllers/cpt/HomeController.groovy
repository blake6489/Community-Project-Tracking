package cpt

import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER'])
class HomeController {

	def index() { }
	def home() {
		if (SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN')) {
			adminHome()
		}
		else if (SpringSecurityUtils.ifAnyGranted('ROLE_USER')) {
			userHome()
		}
	}
	def grails() {
		render(view: "/index")
	}
	
	def adminHome() {
		//def instance = new TimesheetTemplate()
		def projects = Project.list()
		render(view: "adminHome", model: [projects: projects])
	}
	
	def userHome() {
		render(view: "userHome")
	}
	
	def timesheet() {
		if(request.get) {
			return [instance: TimesheetTemplate.get(params.id)]
		}
		else if(request.post) {
			
		}
	}
}
