<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY home.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <title>
      Reports
    </title>
  </head>
  <body>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        Reports
      </h1>
      <g:form action='home' class='ui-widget ui-widget-content ui-corner-all'>
        <fieldset class='table'>
          <div class='row'>
            <div class='cell'>
              <label for='start1'>Date Range</label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:textField class='jq-date' name='start1' required='' />
              to
              <g:textField class='jq-date' name='end1' required='' />
            </div>
          </div>
          <div class='row'>
            <div class='cell'>
              <label for='project'>
                ${message(code: 'project.label')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Project.list()}' name='project' noSelection="['':'Any']" optionKey='id' optionValue='name' />
            </div>
          </div>
          <div class='row required'>
            <div class='cell'>
              <label for='timesheet'>
                ${message(code: 'timesheetTemplate.label')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.TimesheetTemplate.list()}' name='timesheet' noSelection="['':'Any']" optionKey='id' optionValue='name' />
            </div>
          </div>
          <div class='row required'>
            <div class='cell'>
              <label for='worker'>
                ${message(code: 'worker.label')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Worker.list()}' name='worker' noSelection="['':'Any']" optionKey='id' optionValue='name' />
            </div>
          </div>
          <div class='row required'>
            <div class='cell'>
              <label for='activities'>
                ${message(code: 'activity.labels')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Activity.list()}' multiple='multiple' name='activities' optionKey='id' optionValue='name' size='5' value='${cpt.Activity.list()*.id}' />
            </div>
          </div>
          <div class='row required'>
            <div class='cell'>
              <label for='locations'>
                ${message(code: 'location.labels')}
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:select from='${cpt.Location.list()}' multiple='multiple' name='locations' optionKey='id' optionValue='name' size='5' value='${cpt.Location.list()*.id}' />
            </div>
          </div>
        </fieldset>
        <div class='buttons'>
          <input class='jq-button' type='submit' value='Generate Report' />
        </div>
      </g:form>
      <g:if test='${model}'>
        <div class='ui-widget ui-widget-content ui-corner-all'>
          <cpt:report activities='${model.activities}' end='${model.end}' locations='${model.locations}' start='${model.start}' workerId='${model.worker}' />
        </div>
      </g:if>
    </div>
  </body>
</html>