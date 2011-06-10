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
            con = dm.ConnectionManager.getConnection();
            ResDAO resdao = new ResDAO(con);
            ArrayList<Res> rlist = resdao.selectAll();
            request.setAttribute("reslist", rlist);
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
