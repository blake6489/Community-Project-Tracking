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
    <div class='content scaffold-show' id='show-activity' role='main'>
      <h1 class='ui-widget-header ui-corner-all'>
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
          <g:actionSubmit action='delete' class='delete jq-button' onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
        </fieldset>
      </g:form>
    </div>
  </body>
</html>