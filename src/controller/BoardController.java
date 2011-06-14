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
        HttpSession session = request.getSession(true);

        if( "/MainBoard".equals(path) ) {
            nextPage = TopicListController.perform(request, response);
        } else if( "/ResAddAction".equals(path) ) {
            nextPage = ResAddController.perform(request, response);
        } else if( "/TopicAddAction".equals(path) ) {
            nextPage = TopicAddController.perform(request, response);
        } else if( "/MakeTopic".equals(path) ) {
            nextPage = "/WEB-INF/jsp/MakeTopic.jsp";
        } else if( "/ModifyData".equals(path) ) {
            nextPage = UserModifyController.perform(request, response);
        } else if( "/ResListAction".equals(path) ) {
            nextPage = ResListController.perform(request, response);
        } else if("/LoginAction".equals(path)) {
            nextPage = LoginController.perform(request, response);
        } else if("/LoginForm".equals(path)) {
            nextPage = "/WEB-INF/jsp/LoginForm.jsp";
        } else if("/UserAddForm".equals(path)) {
            nextPage = "/WEB-INF/jsp/UserAddForm.jsp";
        } else if("/UserAddAction".equals(path)) {
            nextPage = UserAddController.perform(request, response);
        } else if("/Logout".equals(path)) {
            session.setAttribute("loggedIn", null);
            nextPage = "/WEB-INF/jsp/Logout.jsp";
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
