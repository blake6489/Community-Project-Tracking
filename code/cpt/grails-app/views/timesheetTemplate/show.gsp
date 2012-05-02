<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY show.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='timesheetTemplate' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.show.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button' controller='project'>
            <g:message code='project.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button jq-active-button' controller='timesheetTemplate'>
            <g:message code='timesheetTemplate.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='create' class='jq-button'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        ${entityName}: ${fieldValue(bean: template, field: "name")}
      </h1>
      <cpt:errors bean='${data}'></cpt:errors>
      <g:form action='save' class='ui-widget ui-widget-content ui-corner-all' controller='timesheet'>
        <g:hiddenField name='template.id' value='${template.id}' />
        <g:hiddenField name='project.id' value='${template.project.id}' />
        <fieldset class='table'>
          <div class="${hasErrors(bean: instance, field: 'date', 'error')} row required">
            <div class='cell'>
              <label for='dateString'>
                Date
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:textField class='jq-date' name='dateString' required='' value='${instance.date}' />
            </div>
          </div>
          <div class="${hasErrors(bean: instance, field: 'worker', 'error')} row required">
            <div class='cell'>
              <label for='worker.id'>
                ${message(code: 'worker.label')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Worker.list()}' name='worker.id' optionKey='id' optionValue='name' value='${instance?.worker?.id}' />
            </div>
          </div>
        </fieldset>
        <cpt:timesheetW data='${data}' template='${template}'></cpt:timesheetW>
        <div class='buttons'>
          <input class='jq-button' type='submit' value='Complete Timesheet' />
        </div>
      </g:form>
    </div>
  </body>
</html>