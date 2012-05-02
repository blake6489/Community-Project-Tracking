<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY adminHome.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <title>CPT Home</title>
  </head>
  <body>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        Complete a timesheet
      </h1>
      <div class='ui-widget ui-widget-content ui-corner-all'>
        <g:if test='${!projects.size()}'>
          <h2>
            No projects.
            <g:link action='create' controller='project'>Create a project.</g:link>
          </h2>
        </g:if>
        <ul>
          <g:each in='${projects}' status='i' var='project'>
            <g:each in='${project.templates}' status='j' var='timesheet'>
              <li>
                <g:link action='show' controller='timesheetTemplate' id='${timesheet.id}'>
                  ${fieldValue(bean: project, field: "name")} / ${fieldValue(bean: timesheet, field: "name")}
                </g:link>
              </li>
            </g:each>
          </g:each>
        </ul>
      </div>
    </div>
  </body>
</html>