import communityprojecttracking.Role
import communityprojecttracking.User
import communityprojecttracking.UserRole

class BootStrap {

	def init = { servletContext ->
		//Create users
		if(!User.count()) {
			def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: 'ROLE_ADMIN').save(flush: true)
			def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: 'ROLE_USER').save(flush: true)
	
			def admin = new User(username: 'admin', enabled: true, password: 'a').save(flush: true)
			def user = new User(username: 'user', enabled: true, password: 'a').save(flush: true)
	
			UserRole.create(admin, adminRole, true)
			UserRole.create(admin, userRole, true)
			UserRole.create(user, userRole, true)
		}
	}
	
	def destroy = {
	}
}
