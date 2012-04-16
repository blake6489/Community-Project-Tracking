class UrlMappings {

	static mappings = {
		"/"(controller: "home", action: "home")
		"/login"(controller: "login", action: "login")
		"/login/$action"(controller: "login") {constraints {action(notEqual:"login")}}
		"/logout"(controller: "logout", action: "index")
		
		"/activities"(controller: "activity", action: "list")
		"/activities/$id/$title?"(controller: "activity", action: "show"){constraints {id(matches: /\d+/)}}
		"/activities/create"(controller: "activity", action: "create")
		"/activities/delete/$id"(controller: "activity", action: "delete")
		
		"/locations"(controller: "location", action: "list")
		"/locations/$id/$title?"(controller: "location", action: "show"){constraints {id(matches: /\d+/)}}
		"/locations/create"(controller: "location", action: "create")
		"/locations/delete/$id"(controller: "location", action: "delete")
		
		"/tools"(controller: "tool", action: "list")
		"/tools/$id/$title?"(controller: "tool", action: "show"){constraints {id(matches: /\d+/)}}
		"/tools/create"(controller: "tool", action: "create")
		"/tools/delete/$id"(controller: "tool", action: "delete")
		
		"/users"(controller: "user", action: "list")
		name user_create: "/users/create"(controller:"user"){action = [GET:"create", POST:"save"]}
		"/users/$id/$title?"(controller: "user", action: "show"){constraints {id(matches: /\d+/)}}
		name user_resetPassword: "/users/reset/$id?"(controller: "user", action: "resetPassword")
		//"/users/$action/$id?"(controller: "user"){constraints {action(validator: {!(it in ["list", "show"])})}}
		
		//remove these before production
		"/grails/"(controller: "home", action: "grails")
		"500"(view:'/error')
	}
}
