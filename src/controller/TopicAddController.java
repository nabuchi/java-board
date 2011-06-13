package controller;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Topic;
import dao.TopicDAO;
import dm.ConnectionManager;

public class TopicAddController {
	private TopicAddController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String nextPage = "/WEB-INF/jsp/Error.jsp";
		request.setCharacterEncoding("utf8");

		String userid = request.getParameter("userid");//後でセッションからとってくる
		String title = request.getParameter("title");
		
		if( userid == null || title == null ) {
			request.setAttribute("error", "書き込みに失敗しました"); 
		} else if( title.equals("")){
			request.setAttribute("error", "本文を入力してください"); 
		} else {
			Connection con = null;
			try {
				con = dm.ConnectionManager.getConnection();
				TopicDAO topicdao = new TopicDAO(con);
				Topic topic = new Topic(title, Integer.parseInt(userid));
				request.setAttribute("error", "koko?");
				topic = topicdao.insert(topic);
				if(topic != null) {
					request.setAttribute("topic", topic);
                    nextPage = TopicListController.perform(request, response);
				} else {
					request.setAttribute("error", "書き込みに失敗しました");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(con != null) { con.close(); }
				}catch (Exception e) {}
			}
		}
		return nextPage;
	}
}
