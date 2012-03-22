<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY edit.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'activity.label', default: 'Activity')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.edit.label' />
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
        <li>
          <g:link action='create' class='create'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='content scaffold-edit' id='edit-activity' role='main'>
      <h1>
        <g:message args='[entityName]' code='default.edit.label' />
      </h1>
      <cpt:errors bean='${activityInstance}'></cpt:errors>
      <g:form method='post'>
        <g:hiddenField name='id' value='${activityInstance?.id}' />
        <g:hiddenField name='version' value='${activityInstance?.version}' />
        <fieldset class='form'>
          <g:render template='form' />
        </fieldset>
        <cpt:fieldsetEdit />
      </g:form>
    </div>
  </body>
</html>