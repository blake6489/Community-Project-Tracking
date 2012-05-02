<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY _admin.haml --%>
<header id='header'>
  <ul>
    <li>
      <g:link action='home' controller='home'>
        Home
      </g:link>
    </li>
    <li>
      <g:link action='home' controller='report'>
        Reports
      </g:link>
    </li>
    <li>
      <g:link action='list' controller='project'>
        Projects
      </g:link>
    </li>
    <li>
      <g:link action='list' controller='timesheet'>
        Timesheets
      </g:link>
    </li>
    <li>
      <g:link action='list' controller='activity'>
        Data
      </g:link>
    </li>
    <li>
      <g:link action='list' controller='user'>
        People
      </g:link>
    </li>
    <li style='float:right'>
      <g:link controller='logout'>
        Logout
        <sec:username />
      </g:link>
    </li>
  </ul>
</header>