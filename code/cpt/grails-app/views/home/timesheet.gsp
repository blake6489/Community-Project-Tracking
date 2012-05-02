<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY timesheet.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <title>CPT Home</title>
  </head>
  <body>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        ${fieldValue(bean: instance, field: "project.name")} / ${fieldValue(bean: instance, field: "name")}
      </h1>
      <div class='ui-widget ui-widget-content ui-corner-all'>
        <cpt:timesheetW model='${instance}' />
      </div>
    </div>
  </body>
</html>