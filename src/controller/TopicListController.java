package controller;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.Topic;
import dao.TopicDAO;
import dm.ConnectionManager;

public class TopicListController {
    private TopicListController(){}
    public static String perform(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Connection con = null;
        String nextPage = "/WEB-INF/jsp/Error.jsp";
        try {
            con = dm.ConnectionManager.getConnection();
            TopicDAO topicdao = new TopicDAO(con);
            /*
            HashMap<Topic> tlist = topicdao.selectAllByHash();
            ArrayList<Res> rlist = Resdao.selectAll();
            ArrayList<MCTopic> topiclist = new ArrayList<MCTopic>;
            Iterator<Res> iter = reslist.iterator();
            Res res = null;
            MCTopic mctopic = null;
            int currenttopicid = -1;
            while(iter.hasNext() {
                res = iter.next();
                topicid = res.getTopicId();
                if(currenttopicid != topicid) {
                    mctopic = new MCTopic();
                }
            }
            */
            ArrayList<Topic> topiclist = topicdao.selectAll();

            request.setAttribute("topiclist", topiclist);
            nextPage = "/WEB-INF/jsp/MainBoard.jsp";
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(con != null) { con.close(); }
            } catch(Exception e) {}
        }
        return nextPage;
    }
}
