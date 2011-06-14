package controller;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.Res;
import dao.ResDAO;
import dm.ConnectionManager;

public class ResListController {
    private ResListController(){}
    public static String perform(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Connection con = null;
        String nextPage = "/WEB-INF/jsp/Error.jsp";
        try {
            String topicidstr = request.getParameter("topicid");
            if( topicidstr != null ) {
                int topicid = Integer.parseInt(topicidstr);
                con = dm.ConnectionManager.getConnection();
                ResDAO resdao = new ResDAO(con);
                ArrayList<Res> rlist = resdao.selectByTopicId(topicid);
                request.setAttribute("reslist", rlist);
                nextPage = "/WEB-INF/jsp/ResList.jsp";
            } else {
			    request.setAttribute("error", "topicidが不正です。");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(NumberFormatException e) {
			request.setAttribute("error", "topicidが不正です");
        } finally {
            try {
                if(con != null) { con.close(); }
            } catch(Exception e) {}
        }
        return nextPage;
    }
}
