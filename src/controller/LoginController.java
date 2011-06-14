package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mc.MCUserInfo;
import bean.UserInfo;
public class LoginController{
	private LoginController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		UserInfo user = MCUserInfo.login(userId, password);
		if(user != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
            nextPage = TopicListController.perform(request, response);
		}else{
			request.setAttribute("error", "ログインに失敗しました");
		}
		return nextPage;
	}
}

