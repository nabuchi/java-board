package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BoardController extends HttpServlet {
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        String nextPage = null;

        if( "/MainBoard".equals(path) ) {
            nextPage = ResListController.perform(request, response);
        } else if( "/ResAddAction".equals(path) ) {
            nextPage = ResAddController.perform(request, response);
        } else {
            request.setAttribute("error", "指定されたURLに誤りがあります");
            nextPage = "/WEB-INF/jsp/Error.jsp";
        }
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
