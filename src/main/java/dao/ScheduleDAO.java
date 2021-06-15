package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.ScheduleBean;
import util.DBUtil;

public class ScheduleDAO {
    
    public String createSchedule(ScheduleBean scheduleBean){

        Connection conn = null;

        try{
            
            conn = DBUtil.getDBConnection();

            PreparedStatement pst = conn.prepareStatement("INSERT INTO SCHEDULE_TBL(SCHEDULEID,SOURCE,DESTINATION,STARTTIME,ARRIVALTIME) VALUES(?,?,?,?,?)");

            pst.setString(1, generateID(scheduleBean.getSource(),scheduleBean.getDestination()));
            pst.setString(2, scheduleBean.getSource());
            pst.setString(3,scheduleBean.getDestination());
            pst.setString(4,scheduleBean.getStartTime());
            pst.setString(5,scheduleBean.getArrivalTime());

            System.out.println(pst.toString());

            pst.executeUpdate();

            conn.close();

            return "SUCCESS";
        }
        catch(SQLException se){

            se.printStackTrace();
            return "FAIL";
        }
    }

    public String generateID(String source, String destination){
        String ID = source.toUpperCase().substring(0,2)+destination.toUpperCase().substring(0,2)+((int)Math.random()*(9000) + 1000);
        System.out.println(ID);
        return ID;
    }

    public ArrayList<ScheduleBean> viewSchedule(String source, String destination){
        try{
            Connection conn = DBUtil.getDBConnection();

            Statement st = conn.createStatement();

            System.out.println("SELECT * FROM SCHEDULE_TBL WHERE SOURCE='"+source+"' AND DESTINATION='"+destination+"';");
            
            ResultSet rs = st.executeQuery("SELECT * FROM SCHEDULE_TBL WHERE SOURCE='"+source+"' AND DESTINATION='"+destination+"';");

            ArrayList<ScheduleBean> al = new ArrayList<ScheduleBean>();

            
            while(rs.next()){
                ScheduleBean scheduleBean = new ScheduleBean();
                scheduleBean.setScheduleId(rs.getString("SCHEDULEID"));
                scheduleBean.setSource(rs.getString("SOURCE"));
                scheduleBean.setDestination(rs.getString("DESTINATION"));
                scheduleBean.setStartTime(rs.getString("STARTTIME"));
                scheduleBean.setArrivalTime(rs.getString("ARRIVALTIME"));
                System.out.println(scheduleBean);
                al.add(scheduleBean);
            }

            return al;
        }
        catch(SQLException se){

            se.printStackTrace();

            return null;
        }
    }
}
