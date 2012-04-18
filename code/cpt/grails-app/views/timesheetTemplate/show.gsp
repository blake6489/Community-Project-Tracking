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
        ${entityName}: ${fieldValue(bean: instance, field: "name")}
      </h1>
      <div class='timesheet ui-widget'>
        <table>
          <thead>
            <tr>
              <th></th>
              <g:each in='${instance.locations}' status='i' var='location'>
                <th class='location'>
                  ${fieldValue(bean: location, field: "name")}
                </th>
              </g:each>
            </tr>
          </thead>
          <tbody>
            <g:each in='${instance.activities}' status='i' var='activity'>
              <tr>
                <td class='activity'>
                  ${fieldValue(bean: activity, field: "name")}
                </td>
                <g:each in='${instance.locations}'>
                  <td></td>
                </g:each>
              </tr>
            </g:each>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>