<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY create.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'activity.label', default: 'Activity')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.create.label' />
    </title>
  </head>
  <body>
    <div class='nav' role='navigation'>
      <ul>
        <li>
          <a class='home' href="${createLink(uri: '/')}">
            <g:message code='default.home.label' />
          </a>
        </li>
        <li>
          <g:link action='list' class='list'>
            <g:message args='[entityName]' code='default.list.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='content scaffold-create' id='create-activity' role='main'>
      <h1>
        <g:message args='[entityName]' code='default.create.label' />
      </h1>
      <cpt:errors bean='${activityInstance}'></cpt:errors>
      <g:form action='save'>
        <fieldset class='form'>
          <g:render template='form' />
        </fieldset>
        <cpt:fieldsetCreate />
      </g:form>
    </div>
  </body>
</html>