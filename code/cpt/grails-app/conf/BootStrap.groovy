import cpt.Role
import cpt.User
import cpt.UserRole

import cpt.Location

class BootStrap {

	def init = { servletContext ->
		//Create users
		if(!User.count()) {
			def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: 'ROLE_ADMIN', type: 'admin').save(flush: true)
			def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: 'ROLE_USER', type: 'user').save(flush: true)
			
			new User(type: 'admin', username: 'admin', enabled: true, password: 'a').createWithUserRole(true)
			new User(type: 'user', username: 'user', enabled: true, password: 'a').createWithUserRole(true)
		}
		new Location(name: 'one').save()
		new Location(name: 'two').save()
		new Location(name: 'three').save()
		new Location(name: 'four').save()
		new Location(name: 'five').save()
		new Location(name: 'six').save()
		new Location(name: 'seven').save()
		new Location(name: 'eight').save()
		new Location(name: 'nine').save()
		new Location(name: 'ten').save()
		new Location(name: 'eleven').save()
		new Location(name: 'twelve').save()
		new Location(name: 'thirteen').save()
		new Location(name: 'fourteen').save()
		new Location(name: 'fifteen').save()
		new Location(name: 'sixteen').save()
	}

	def destroy = {
	}
}
