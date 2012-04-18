<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY create.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <g:set value='tool' var='className' />
    <g:set value="${message(code: className+'.label')}" var='entityName' />
    <title>
      <g:message args='[entityName]' code='default.create.label' />
    </title>
  </head>
  <body>
    <div class='subnav'>
      <ul>
        <li>
          <g:link action='list' class='jq-button' controller='activity'>
            <g:message code='activity.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button' controller='location'>
            <g:message code='location.labels' />
          </g:link>
        </li>
        <li>
          <g:link action='list' class='jq-button' controller='tool'>
            <g:message code='tool.labels' />
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
          <div class="${hasErrors(bean: instance, 'error')} row required">
            <div class='cell'>
              <label for='names'>
                Names
                <br />
                (one per line)
              </label>
            </div>
            <div class='cell'>
              <div class='required-indicator'>*</div>
            </div>
            <div class='cell'>
              <g:textArea name='names' required='' value='${names}' />
            </div>
          </div>
        </fieldset>
        <cpt:fieldsetCreate />
      </g:form>
    </div>
  </body>
</html>