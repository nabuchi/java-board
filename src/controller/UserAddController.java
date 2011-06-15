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

public class UserAddController {
	private UserAddController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String nextPage = "/WEB-INF/jsp/Error.jsp";
		request.setCharacterEncoding("utf8");

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
			request.setAttribute("error", "ちゃんとフォームから登録して下さい"); 
		} else {
			Connection con = null;
			try {
				con = dm.ConnectionManager.getConnection();
				UserInfoDAO userdao = new UserInfoDAO(con);
                String birthdate = birthyear + "/" + birthmonth + "/" + birthday;
				UserInfo user = new UserInfo(name, password, birthdate);
				user = userdao.insert(user);
				if(user != null) {
					request.setAttribute("user", user);
                    nextPage = "/WEB-INF/jsp/toTop.jsp";
				} else {
					request.setAttribute("error", "追加に失敗しました");
				}
			} catch (SQLException e) {
			    request.setAttribute("error", "SQLエラー");
				e.printStackTrace();
            } catch (ParseException e) {
			    request.setAttribute("error", "生年月日のパースエラー");
			} finally {
				try {
					if(con != null) { con.close(); }
				}catch (Exception e) {}
			}
		}
		return nextPage;
	}
}
