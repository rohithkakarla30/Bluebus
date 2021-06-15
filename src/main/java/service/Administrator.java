package service;

import java.util.ArrayList;

import bean.ScheduleBean;
import dao.ScheduleDAO;

public class Administrator {

    public String addSchedule(ScheduleBean scheduleBean){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        return scheduleDAO.createSchedule(scheduleBean);
    }

    public ArrayList<ScheduleBean> viewSchedule(String source, String destination){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        return scheduleDAO.viewSchedule(source, destination);
    }
}
