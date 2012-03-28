import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

// Place your Spring DSL code here
beans = {
	groovyPageResourceLoader(com.cadrlife.jhaml.grailsplugin.HamlGroovyPageResourceLoader) {
		baseResource = "file:."
		pluginSettings = new grails.util.PluginBuildSettings(grails.util.BuildSettingsHolder.settings)
	  }
	authenticationEntryPoint(cpt.AuthenticationEntryPoint) {
		loginFormUrl = SpringSecurityUtils.securityConfig.auth.loginFormUrl
		forceHttps = SpringSecurityUtils.securityConfig.auth.forceHttps
		ajaxLoginFormUrl = SpringSecurityUtils.securityConfig.auth.ajaxLoginFormUrl
		useForward = SpringSecurityUtils.securityConfig.auth.useForward
		portMapper = ref('portMapper')
		portResolver = ref('portResolver')

	}
	/*authenticationFailureHandler(cpt.AuthenticationFailureHandler) {}*/
	  
}
