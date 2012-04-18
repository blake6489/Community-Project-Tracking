package cpt

class CptFilters {
	//injection
	def grailsApplication
	
	def filters = {
		paginationSettings(controller: '*', action: '*') {
			before = {
				def paginate = grailsApplication.config.cpt.paginate
				params.max = Math.min(params.max ? params.int('max') : paginate.max.default, paginate.max.max)
				params.maxsteps = params.maxsteps ?: paginate.maxsteps.default
			}
		}
	}
}
