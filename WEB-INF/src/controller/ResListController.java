package controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import bean.Res;
import dao.ResDAO;
import dm.ConnectionManager;

public class ResListController {
    private ResAddController(){}
    public static String perform(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String nextPage = "/WEB-INF/jsp/Error.jsp";
        try {
            con = dm.ConnectionManager.getConnection();
            ResDAO resdao = new ResDAO(con);
            Res res = new Res(author, content);
            ArrayList<Res> rlist = resdao.selectAll();
            request.setAttribute("reslist", rlist);
            nextPage = ;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(con != null) { con.close(); }
            } catch(Exception e) {}
        }
    }
}
