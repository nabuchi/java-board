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
            nextPage = "/WEB-INF/jsp/MainBoard.jsp";
        } else {
            request.setAttribute("error", "指定されたURLに誤りがあります");
            nextPage = "/WEB-INF/jsp/Error.jsp";
        }
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}
