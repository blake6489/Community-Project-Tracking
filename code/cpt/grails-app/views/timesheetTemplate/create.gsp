<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY create.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='timesheetTemplate' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.create.label' />
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
          <g:link action='list' class='jq-button' controller='timesheetTemplate'>
            <g:message code='timesheetTemplate.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='create' class='jq-button jq-active-button'>
            <g:message args='[entityName]' code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        <g:message args='[entityName]' code='default.create.label' />
      </h1>
      <cpt:errors bean='${instance}'></cpt:errors>
      <g:form action='create' class='ui-widget ui-widget-content ui-corner-all'>
        <fieldset class='table'>
          <g:if test='${params.id}'>
            <g:hiddenField name='project.id' value='${params.id}' />
          </g:if>
          <g:else>
            <div class="${hasErrors(bean: instance, field: 'project', 'error')} row required">
              <div class='cell'>
                <label for='project.id'>
                  ${message(code: 'project.label')}
                </label>
              </div>
              <div class='cell'>
                <div class='required-indicator'>*</div>
              </div>
              <div class='cell'>
                <g:select from='${cpt.Project.list()}' name='project.id' optionKey='id' optionValue='name' value='${instance?.project?.id}' />
              </div>
            </div>
          </g:else>
          <div class="${hasErrors(bean: instance, field: 'name', 'error')} row required">
            <div class='cell'>
              <label for='name'>
                ${message(code: className+'.name.label', default: 'Name')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:textField name='name' required='' value='${instance.name}' />
            </div>
          </div>
          <div class="${hasErrors(bean: instance, field: 'activities', 'error')} row required">
            <div class='cell'>
              <label for='activities'>
                ${message(code: 'activity.labels')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Activity.list()}' multiple='multiple' name='activities' optionKey='id' optionValue='name' size='5' value='${instance?.activities*.id}' />
            </div>
          </div>
          <div class="${hasErrors(bean: instance, field: 'locations', 'error')} row required">
            <div class='cell'>
              <label for='locations'>
                ${message(code: 'location.labels')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Location.list()}' multiple='multiple' name='locations' optionKey='id' optionValue='name' size='5' value='${instance?.locations*.id}' />
            </div>
          </div>
        </fieldset>
        <cpt:fieldsetCreate />
      </g:form>
    </div>
  </body>
</html>