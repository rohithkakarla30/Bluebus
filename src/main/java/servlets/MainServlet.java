package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ScheduleBean;
import service.Administrator;
import util.InvalidInputException;

public class MainServlet extends HttpServlet {
    
    public String addSchedule(HttpServletRequest request){
        
        ScheduleBean scheduleBean = new ScheduleBean();
        scheduleBean.setSource(request.getParameter("source"));
        scheduleBean.setDestination(request.getParameter("destination"));
        scheduleBean.setStartTime(request.getParameter("startTime"));
        scheduleBean.setArrivalTime(request.getParameter("arrivalTime"));

        System.out.println(scheduleBean);

        Administrator administrator = new Administrator();
        return administrator.addSchedule(scheduleBean);

    }

    public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request){
        Administrator administrator = new Administrator();
        return administrator.viewSchedule(request.getParameter("source"),request.getParameter("destination"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String operation = request.getParameter("operation");
        if(operation.equals("newSchedule")){
            String status = addSchedule(request);
            if(status.equals("SUCCESS")){
                response.sendRedirect("/success.jsp");
            }
            else{
                response.sendRedirect("/errorInserting.html");
            }
        }
        else if(operation.equals("viewSchedule")){
            try {
                if(request.getParameter("source")==null || request.getParameter("destination")==null){
                    throw new InvalidInputException();
                }
                else{
                    ArrayList<ScheduleBean> al = viewSchedule(request);
                    request.setAttribute("data", al);
                    RequestDispatcher rd = request.getRequestDispatcher("/displaySchedule.jsp");
                    rd.forward(request,response);
                }
            } 
            catch (InvalidInputException e) {
                    e.printStackTrace();
                }
            }

        }
}
