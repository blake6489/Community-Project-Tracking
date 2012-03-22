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
      <g:render template='/layouts/login'></g:render>
    </sec:ifNotLoggedIn>
    <sec:ifLoggedIn>
      <sec:ifAnyGranted roles='ROLE_ADMIN'>
        <g:render template='/layouts/admin'></g:render>
      </sec:ifAnyGranted>
      <sec:ifAnyGranted roles='ROLE_USER'>
        <g:render template='/layouts/user'></g:render>
      </sec:ifAnyGranted>
      <g:if test='${flash.message}'>
        <div id='flash'>${flash.message}</div>
      </g:if>
      <g:layoutBody />
    </sec:ifLoggedIn>
    <r:layoutResources />
  </body>
</html>