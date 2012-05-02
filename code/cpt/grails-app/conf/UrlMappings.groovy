class UrlMappings {

	static mappings = {
		"/"(controller: "home", action: "home")
		"/login"(controller: "login", action: "login")
		"/login/$action"(controller: "login") {constraints {action(notEqual:"login")}}
		"/logout"(controller: "logout", action: "index")
		
		"/data/activities"(controller: "activity", action: "list")
		"/data/activities/$id/$title?"(controller: "activity", action: "show"){constraints {id(matches: /\d+/)}}
		"/data/activities/create"(controller: "activity", action: "create")
		"/data/activities/delete/$id"(controller: "activity", action: "delete")
		
		"/data/locations"(controller: "location", action: "list")
		"/data/locations/$id/$title?"(controller: "location", action: "show"){constraints {id(matches: /\d+/)}}
		"/data/locations/create"(controller: "location", action: "create")
		"/data/locations/delete/$id"(controller: "location", action: "delete")
		
		"/data/tools"(controller: "tool", action: "list")
		"/data/tools/$id/$title?"(controller: "tool", action: "show"){constraints {id(matches: /\d+/)}}
		"/data/tools/create"(controller: "tool", action: "create")
		"/data/tools/delete/$id"(controller: "tool", action: "delete")
		
		"/people/accounts"(controller: "user", action: "list")
		"/people/accounts/$id/$title?"(controller: "user", action: "show"){constraints {id(matches: /\d+/)}}
		"/people/accounts/create"(controller:"user", action: "create")
		"/people/accounts/reset/$id?"(controller: "user", action: "resetPassword")
		
		"/people/workers"(controller: "worker", action: "list")
		"/people/workers/$id/$title?"(controller: "worker", action: "show"){constraints {id(matches: /\d+/)}}
		"/people/workers/create"(controller:"worker", action: "create")
		"/data/locations/delete/$id"(controller: "worker", action: "delete")
		
		"/projects"(controller: "project", action: "list")
		"/projects/$id/$title?"(controller: "project", action: "show"){constraints {id(matches: /\d+/)}}
		"/projects/create"(controller: "project", action: "create")
		"/projects/delete/$id"(controller: "project", action: "delete")
		
		"/projects/timesheets"(controller: "timesheetTemplate", action: "list")
		"/projects/timesheets/$id/$title?"(controller: "timesheetTemplate", action: "show"){constraints {id(matches: /\d+/)}}
		"/projects/timesheets/create/$id?"(controller: "timesheetTemplate", action: "create")
		"/projects/timesheets/delete/$id"(controller: "timesheetTemplate", action: "delete")
		"/projects/timesheets/complete"(controller: "timesheet", action: "save")
		
		"/timesheets"(controller: "timesheet", action: "list")
		"/timesheets/$id"(controller: "timesheet", action: "show"){constraints {id(matches: /\d+/)}}
		
		"/reports"(controller: "report", action: "home")
		
		//remove these before production
		"/grails/"(controller: "home", action: "grails")
		"500"(view:'/error')
	}
}
