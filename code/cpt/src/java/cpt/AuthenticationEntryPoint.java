package cpt;

import org.codehaus.groovy.grails.plugins.springsecurity.AjaxAwareAuthenticationEntryPoint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;

/**
 * Custom entry point that passes the requested url in the query.
 * 
 * This is intended to better support cases where the user is browsing with multiple tabs/windows.
 * I don't know whether overriding buildRedirectUrlToLoginPage or determineUrlToUseForThisRequest is better.
 */
public class AuthenticationEntryPoint extends AjaxAwareAuthenticationEntryPoint {
	/*@Override
	protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
		return super.buildRedirectUrlToLoginPage(request, response, authException) + "?url=" + request.getRequestURL().toString();
	}*/
	
	@Override
	protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
		return super.determineUrlToUseForThisRequest(request, response, authException) + "?url=" + request.getRequestURL().toString();
	}
}
