<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY list.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='timesheet' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.list.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button jq-active-button' controller='timesheet'>
            Completed Timesheets
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <table class='list ui-widget ui-widget-content ui-corner-all'>
        <thead>
          <tr>
            <g:sortableColumn property='template.name' title="${message(code: 'timesheetTemplate.label')}" />
            <g:sortableColumn property='date' title='Date' />
            <g:sortableColumn property='worker.name' title="${message(code: 'worker.label')}" />
          </tr>
        </thead>
        <tbody>
          <g:each in='${list}' status='i' var='instance'>
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
              <td>
                <g:link action='show' id='${instance.id}'>${fieldValue(bean: instance, field: "template.name")}</g:link>
              </td>
              <td>
                <g:link action='show' id='${instance.id}'>${formatDate(date: instance.date)}</g:link>
              </td>
              <td>
                <g:link action='show' id='${instance.id}'>${fieldValue(bean: instance, field: "worker.name")}</g:link>
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