package cpt

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class HomeController {

	def index() { }
	def home() {
		
	}
	def grails() {
		render(view: "/index")
	}
}
