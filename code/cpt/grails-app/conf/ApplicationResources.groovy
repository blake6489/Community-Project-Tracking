modules = {
	application {
		resource url:'js/application.js'
	}
	overrides {
		'jquery-theme' {
			resource id:'theme', url:'/css/black-tie/jquery-ui-1.8.18.custom.css'
		}
	}
	cpt {
		dependsOn 'jquery, jquery-ui'
		resource url: '/css/cpt.css'
		resource url: '/js/cpt.js'
	}
}