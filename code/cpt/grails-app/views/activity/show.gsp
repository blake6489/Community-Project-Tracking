<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY show.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value="${message(code: 'activity.label', default: 'Activity')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.show.label' />
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
    <div class='content scaffold-show' id='show-activity' role='main'>
      <h1>
        <g:message args='[entityName]' code='default.show.label' />
      </h1>
      <ol class='property-list activity'>
        <g:if test='${activityInstance?.name}'>
          <li class='fieldcontain'>
            <span class='property-label' id='name-label'>
              <g:message code='activity.name.label' default='Name' />
            </span>
            <span aria-labelledby='name-label' class='property-value'>
              <g:fieldValue bean='${activityInstance}' field='name' />
            </span>
          </li>
        </g:if>
      </ol>
      <g:form>
        <fieldset class='buttons'>
          <g:hiddenField name='id' value='${activityInstance?.id}' />
          <g:link action='edit' class='edit' id='${activityInstance?.id}'>
            <g:message code='default.button.edit.label' default='Edit' />
          </g:link>
          <g:actionSubmit action='delete' class='delete' onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
        </fieldset>
      </g:form>
    </div>
  </body>
</html>