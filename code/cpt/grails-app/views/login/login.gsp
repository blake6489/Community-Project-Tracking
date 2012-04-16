<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY login.haml --%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
    <g:javascript library='jquery' />
    <r:require module='cpt' />
    <r:layoutResources />
  </head>
  <body>
    <header id='header'>
      <ul>
        <li class='ui-tabs-selected ui-state-active'>
          <g:link action='login' controller='login'>
            Login
          </g:link>
        </li>
      </ul>
    </header>
    <div class='main'>
      <h1 class='ui-widget-header ui-corner-all'>
        Please Login
      </h1>
      <form action='${postUrl}' class='ui-widget ui-widget-content ui-corner-all' id='loginForm' method='POST' name='loginForm'>
        <input name='ajax' type='hidden' value='true' />
        <fieldset class='table'>
          <div class='row'>
            <div class='cell'>
              <label for='username'>Username</label>
            </div>
            <div class='cell'>
              <div class='required-indicator'></div>
            </div>
            <div class='cell'>
              <input autofocus='true' id='username' name='j_username' type='text' />
            </div>
          </div>
          <div class='row'>
            <div class='cell'>
              <label for='password'>Password</label>
            </div>
            <div class='cell'>
              <div class='required-indicator'></div>
            </div>
            <div class='cell'>
              <input id='password' name='j_password' type='password' />
            </div>
          </div>
          <div class='row'>
            <div class='cell'>
              <label for='rememberMe'>Remember me</label>
            </div>
            <div class='cell'>
              <div class='required-indicator'></div>
            </div>
            <div class='cell'>
              <input id='rememberMe' name='${rememberMeParameter}' type='checkbox' />
            </div>
          </div>
        </fieldset>
        <div class='buttons'>
          <input class='jq-button' onclick='ajaxLogin();return false' type='submit' value='Login' />
        </div>
      </form>
    </div>
    <%-- allow ajax submit --%>
    <script type='text/javascript'>
      //<![CDATA[
        function ajaxLogin() {
        	var form = $('#loginForm')
        	$.post(form.attr('action'), form.serialize(), function(data, textStatus, jqXHR){
        		if (data.error) alert(data.error + '\nTODO: Get rid of this popup.')
        		else if (data.success) $(document).ajaxStop(function() { location.reload(true); });
        	})
        }
      //]]>
    </script>
    <r:layoutResources />
  </body>
</html>