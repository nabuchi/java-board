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

public class RepublishController {
	private RepublishController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String nextPage = "/WEB-INF/jsp/Error.jsp";
		request.setCharacterEncoding("utf8");

        //always not null
        HttpSession session = request.getSession(false);

		String name = request.getParameter("name");
		String newpassword = request.getParameter("newpassword");
        String birthyear = request.getParameter("birthyear");
        String birthmonth = request.getParameter("birthmonth");
        String birthday = request.getParameter("birthday");
		
		if( name == null ||
            newpassword == null ||
            birthyear == null ||
            birthmonth == null ||
            birthday == null) {
			request.setAttribute("error", "入力が不正です"); 
        } else if(name.equals("") || newpassword.equals("")) {
			request.setAttribute("error", "必要事項が入力されていません"); 
		} else {
			Connection con = null;
			try {
			    con = dm.ConnectionManager.getConnection();
			    UserInfoDAO userdao = new UserInfoDAO(con);
                String birthdate = birthyear + "/" + birthmonth  + "/" + birthday;
                UserInfo user = new UserInfo(name, newpassword, birthdate);
                if( (user = userdao.selectByNameBirth(user)) != null ) {
                    user.setPassword(newpassword);
                    userdao.updateById(user.getId(), user);
                    nextPage = "/WEB-INF/jsp/toTop.jsp";
                } else {
				    request.setAttribute("error", "ユーザー情報が間違っています");
                }
			} catch (SQLException e) {
				request.setAttribute("error", "SQLエラー");
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
