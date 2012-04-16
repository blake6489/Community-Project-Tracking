package cpt

class User {

	transient springSecurityService

	String username
	String uniqueUsername
	String password
	String type
	Worker worker
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, validator: { val, obj ->
			def other = User.findByUniqueUsername(obj.uniqueUsername)
			if(other && other.id != obj.id) {
				if(other.username.equals(obj.username)) return 'default.not.unique.message'
				else return ['default.too.similar.message', other.username]
			} 
		}
		uniqueUsername blank: true, nullable: true//, bindable: false
		password blank: false
		type inList: ['user', 'admin']//, bindable: false
		worker nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
	
	void setUsername(String value) {
		uniqueUsername = value.toLowerCase()
		username = value
	}
	
	//allows creating of a User and its UserRole. Use this instead of save()
	User createWithUserRole(boolean flush = false) {
		def user = null
		def role = Role.findByType(this.type)
		def userRole = null
		User.withTransaction { status ->
			user = this.save(flush: flush)
			if (!user) {
				status.setRollbackOnly()
			}
			else {
				userRole = UserRole.create(user, role, flush)
				if (!userRole) {
					user = null
					this.errors.reject("Unable to create UserRole")
					status.setRollbackOnly()
				}
			}
		}
		return user
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
