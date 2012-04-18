import cpt.Role
import cpt.User
import cpt.UserRole

import cpt.Location
import cpt.Activity

class BootStrap {

	def init = { servletContext ->
		//Create users
		if(!User.count()) {
			def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: 'ROLE_ADMIN', type: 'admin').save(flush: true)
			def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: 'ROLE_USER', type: 'user').save(flush: true)
			
			new User(type: 'admin', username: 'admin', enabled: true, password: 'a').createWithUserRole(true)
			new User(type: 'user', username: 'user', enabled: true, password: 'a').createWithUserRole(true)
		}
		new Location(name: '1st-3rd Core Area').save()
		new Location(name: '4th-7th').save()
		new Location(name: 'Lacey to Dunkle').save()
		new Location(name: 'Cushman to Wickersham & Bridge').save()
		new Location(name: 'Griffen to Wendell & Bridge').save()
		new Location(name: 'North Cushman').save()
		
		new Activity(name: 'Trash').save()
		new Activity(name: 'Snow Removal').save()
		new Activity(name: 'Ice Chipping').save()
		new Activity(name: 'Unsanitary Deposits').save()
		new Activity(name: 'Inebriate Activity').save()
		new Activity(name: 'Garage Maintenance').save()
		new Activity(name: 'Special Projects').save()
		new Activity(name: 'Sweeping').save()
		new Activity(name: 'Blowing').save()
		new Activity(name: 'Washing').save()
	}

	def destroy = {
	}
}
