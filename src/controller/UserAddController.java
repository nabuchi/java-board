package controller;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.UserInfo;
import dao.UserInfoDAO;
import dm.ConnectionManager;

public class UserAddController {
	private UserAddController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String nextPage = "/WEB-INF/jsp/Error.jsp";
		request.setCharacterEncoding("utf8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
        String secretQuestion = request.getParameter("secret_question");
        String secretQuestionAnswer = request.getParameter("secret_question_answer");
		
		if( name == null ||
            password == null ||
            secretQuestion == null ||
            secretQuestionAnswer == null) {
			request.setAttribute("error", "書き込みに失敗しました"); 
		} else {
			Connection con = null;
			try {
				con = dm.ConnectionManager.getConnection();
				UserInfoDAO userdao = new UserInfoDAO(con);
				UserInfo user = new UserInfo(name, password, secretQuestion, secretQuestionAnswer);
				user = userdao.insert(user);
				if(user != null) {
					request.setAttribute("user", user);
                    nextPage = "/WEB-INF/jsp/UserAddConfirm.jsp";
				} else {
					request.setAttribute("error", "書き込みに失敗しました");
				}
			} catch (SQLException e) {
				e.printStackTrace();
            } catch (NumberFormatException e) {
					request.setAttribute("error", "書き込みに失敗しました");
			} finally {
				try {
					if(con != null) { con.close(); }
				}catch (Exception e) {}
			}
		}
		return nextPage;
	}
}
