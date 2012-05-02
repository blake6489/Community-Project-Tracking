<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY _report.haml --%>
<div class='timesheet ui-widget'>
  <table>
    <thead>
      <tr>
        <th></th>
        <g:each in='${locations}' status='i' var='location'>
          <th class='location'>
            ${location}
            ${fieldValue(bean: cpt.Location.get(location), field: "name")}
          </th>
        </g:each>
      </tr>
    </thead>
    <tbody>
      <g:each in='${activities}' status='i' var='activity'>
        <%--%g:each(in="${data[activity]?.keySet()}" var="tool")--%>
        <tr>
          <td class='activity'>
            ${fieldValue(bean: cpt.Activity.get(activity), field: "name")}
          </td>
          <g:each in='${locations}' var='location'>
            <td>
              <%--%g:set(var="minutes" value="${data[activity][tool][location].minutes/60}${data[activity][tool][location].minutes%60 > 0 ? String.format(":%2", )data[activity][tool][location].minutes%60 : ""}")/--%>
              <g:set value='${data.get(activity).get(location)}' var='minutes' />
              ${minutes}
            </td>
          </g:each>
        </tr>
      </g:each>
    </tbody>
  </table>
</div>