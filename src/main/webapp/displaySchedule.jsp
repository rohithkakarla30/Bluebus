<!DOCTYPE html>
<html>
<head>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <style>
        table, th, td {
            border: 1px solid black;
          }
    </style>
</head>
<body>
    <%@ page import="bean.ScheduleBean"%>
    <%@ page import="java.util.*" %>
    
        <%
            System.out.println("Hello");
            System.out.println(request.getAttribute("data"));
            ArrayList<ScheduleBean> al = (ArrayList)request.getAttribute("data");
            if(al.size()!=0){
        %>
        <table>
            <tr>
                <th>SCHEDULE ID</th>
                <th>SOURCE</th>
                <th>DESTINATION</th>
                <th>START TIME</th>
                <th>ARRIVAL TIME</th>
            </tr>
        <%
            for(ScheduleBean scheduleBean : al){
        %>
        <tr>
            <td>
                <%= scheduleBean.getScheduleId() %>
            </td>
            <td>
                <%= scheduleBean.getSource() %>
            </td>
            <td>
                <%= scheduleBean.getDestination() %>
            </td>
            <td>
                <%= scheduleBean.getStartTime() %>
            </td>
            <td>
                <%= scheduleBean.getArrivalTime() %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
        <%
        }
        else{
        %>
        <h2>No matching schedules exists! Please try again!</h2>
        <%
        }
        %>
</body>
</html>