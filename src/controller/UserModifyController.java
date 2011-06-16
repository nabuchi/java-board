package controller;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.UserInfo;
import dao.UserInfoDAO;
import dm.ConnectionManager;

public class UserModifyController {
	private UserModifyController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String nextPage = "/WEB-INF/jsp/Error.jsp";
		request.setCharacterEncoding("utf8");

        //always not null
        HttpSession session = request.getSession(false);

		String name = request.getParameter("name");
		String password = request.getParameter("password");
        String birthyear = request.getParameter("birthyear");
        String birthmonth = request.getParameter("birthmonth");
        String birthday = request.getParameter("birthday");
		
		if( name == null ||
            password == null ||
            birthyear == null ||
            birthmonth == null ||
            birthday == null) {
			request.setAttribute("error", "入力が不正です"); 
        } else if(name.equals("") || password.equals("")) {
			request.setAttribute("error", "必要事項が入力されていません"); 
		} else {
			Connection con = null;
			try {
			    con = dm.ConnectionManager.getConnection();
			    UserInfoDAO userdao = new UserInfoDAO(con);
                String birthdate = birthyear + "/" + birthmonth  + "/" + birthday;
			    UserInfo user = new UserInfo(name, password, birthdate);
                userdao.updateById((Integer)session.getAttribute("id"), user);
                session.setAttribute("user", user.getName());
                session.setAttribute("birthday", user.getBirthday());
                session.setAttribute("loggedIn", true);
                nextPage = "/WEB-INF/jsp/toTop.jsp";
			} catch (SQLException e) {
				request.setAttribute("error", "同じユーザー名が登録されています");
				e.printStackTrace();
            } catch (NumberFormatException e) {
				request.setAttribute("error", "書き込みに失敗しました");
            } catch (ParseException e) {
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
