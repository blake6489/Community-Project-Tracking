<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY list.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='timesheetTemplate' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.list.label' />
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
            <g:message args="['']" code='default.new.label' />
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <table class='list ui-widget ui-widget-content ui-corner-all'>
        <thead>
          <tr>
            <g:sortableColumn property='name' title="${message(code: className+'.name.label', default: 'Name')}" />
            <g:sortableColumn property='project.name' title="${message(code: 'project.label')}" />
          </tr>
        </thead>
        <tbody>
          <g:each in='${list}' status='i' var='instance'>
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
              <td>
                <g:link action='show' id='${instance.id}'>${fieldValue(bean: instance, field: "name")}</g:link>
              </td>
              <td>
                <g:link action='show' controller='project' id='${instance.project.id}'>${fieldValue(bean: instance, field: "project.name")}</g:link>
              </td>
            </tr>
          </g:each>
        </tbody>
      </table>
      <div class='pagination'>
        <g:paginate maxsteps='${params.maxsteps}' total='${total}' />
      </div>
    </div>
  </body>
</html>