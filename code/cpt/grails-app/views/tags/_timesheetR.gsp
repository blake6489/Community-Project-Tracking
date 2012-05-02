<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY _timesheetR.haml --%>
<div class='timesheet'>
  <table>
    <thead>
      <tr>
        <th></th>
        <g:each in='${model.locations}' status='i' var='location'>
          <th class='location'>
            ${fieldValue(bean: location, field: "name")}
          </th>
        </g:each>
      </tr>
    </thead>
    <tbody>
      <g:each in='${model.activities}' status='i' var='activity'>
        <tr>
          <td class='activity'>
            ${fieldValue(bean: activity, field: "name")}
          </td>
          <g:each in='${model.locations}'>
            <td></td>
          </g:each>
        </tr>
      </g:each>
    </tbody>
  </table>
</div>