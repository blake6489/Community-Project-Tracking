class UrlMappings {

	static mappings = {
		"/"(controller: "home", action: "home")
		"/login"(controller: "login", action: "login")
		"/login/$action"(controller: "login") {constraints {action(notEqual:"login")}}
		"/logout"(controller: "logout", action: "index")
		
		"/activities"(controller: "activity", action: "list")
		"/activities/$id/$title?"(controller: "activity", action: "show"){constraints {id(matches: /\d+/)}}
		"/activities/$action/$id?"(controller: "activity"){constraints {action(validator: {!(it in ["list", "show"])})}}
		
		"/locations"(controller: "location", action: "list")
		"/locations/$id/$title?"(controller: "location", action: "show"){constraints {id(matches: /\d+/)}}
		"/locations/$action/$id?"(controller: "location"){constraints {action(validator: {!(it in ["list", "show"])})}}
		
		"/tools"(controller: "tool", action: "list")
		"/tools/$id/$title?"(controller: "tool", action: "show"){constraints {id(matches: /\d+/)}}
		"/tools/$action/$id?"(controller: "tool"){constraints {action(validator: {!(it in ["list", "show"])})}}
		
		"/users"(controller: "user", action: "list")
		"/users/$id/$title?"(controller: "user", action: "show"){constraints {id(matches: /\d+/)}}
		"/users/$action/$id?"(controller: "user"){constraints {action(validator: {!(it in ["list", "show"])})}}
		
		//remove these before production
		"/grails/"(controller: "home", action: "grails")
		"/grails/$controller/$action?/$id?"{}
		"500"(view:'/error')
	}
}
