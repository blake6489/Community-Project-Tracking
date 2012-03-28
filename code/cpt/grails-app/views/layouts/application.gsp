<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY application.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <title>
      <g:layoutTitle default='No Title'></g:layoutTitle>
    </title>
    <g:layoutHead />
    <%--%link(rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css")--%>
    <g:javascript library='jquery' />
    <r:layoutResources />
  </head>
  <body>
    <sec:ifNotLoggedIn>
      <%-- todo --%>
    </sec:ifNotLoggedIn>
    <sec:ifLoggedIn>
      <g:if test="${org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN')}">
        <g:render template='/layouts/admin'></g:render>
      </g:if>
      <g:elseif test="${org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils.ifAnyGranted('ROLE_USER')}">
        <g:render template='/layouts/user'></g:render>
      </g:elseif>
    </sec:ifLoggedIn>
    <g:if test='${flash.message}'>
      <div id='flash'>${flash.message}</div>
    </g:if>
    <g:layoutBody />
    <r:layoutResources />
  </body>
</html>