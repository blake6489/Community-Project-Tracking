<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY show.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='timesheet' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.show.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button' controller='timesheet'>
            Completed Timesheets
          </g:link>
        </li>
      </ul>
    </div>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        ${entityName}: ${fieldValue(bean: template, field: "project.name")} - ${fieldValue(bean: template, field: "name")}
      </h1>
      <div class='ui-widget ui-widget-content ui-corner-all'>
        <fieldset class='table'>
          <div class='row'>
            <div class='cell'>
              <label for='dateString'>
                Date
              </label>
            </div>
            <div class='cell r'>
              <div>
                <g:formatDate date='${data.date}' />
              </div>
            </div>
          </div>
          <div class='row'>
            <div class='cell'>
              <label for='worker'>
                Worker
              </label>
            </div>
            <div class='cell r'>
              <div>
                <g:fieldValue bean='${data}' field='worker.name' />
              </div>
            </div>
          </div>
        </fieldset>
        <cpt:timesheetW data='${data}' template='${template}'></cpt:timesheetW>
      </div>
    </div>
  </body>
</html>