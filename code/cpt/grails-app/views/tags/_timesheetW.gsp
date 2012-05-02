<%-- DO NOT MODIFY THIS FILE, IT IS AUTOMATICALLY GENERATED. INSTEAD MODIFY _timesheetW.haml --%>
<div class='timesheet ui-widget'>
  <table>
    <thead>
      <tr>
        <th></th>
        <g:each in='${template.locations}' status='i' var='location'>
          <th class='location'>
            ${fieldValue(bean: location, field: "name")}
          </th>
        </g:each>
      </tr>
    </thead>
    <tbody>
      <g:each in='${template.activities}' status='i' var='activity'>
        <%--%g:each(in="${data[activity]?.keySet()}" var="tool")--%>
        <tr>
          <td class='activity'>
            ${fieldValue(bean: activity, field: "name")}
          </td>
          <g:each in='${template.locations}' var='location'>
            <td>
              <%--%g:set(var="minutes" value="${data[activity][tool][location].minutes/60}${data[activity][tool][location].minutes%60 > 0 ? String.format(":%2", )data[activity][tool][location].minutes%60 : ""}")/--%>
              <g:set value="${data?.get(activity.id)?.get(tool?.id ?: 'null')?.get(location.id)?.minutes}" var='minutes' />
              <g:textField name='cell.${activity.id}-${location.id}-${tool?.id}' value='${minutes}' />
            </td>
          </g:each>
        </tr>
      </g:each>
    </tbody>
  </table>
</div>