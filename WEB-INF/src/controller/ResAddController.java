package controller;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Res;

import dao.ResDAO;
import dm.ConnectionManager;

public class ResAddController {
	private ResAddController(){}
	public static String perform(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		request.setCharacterEncoding("utf8");
		if( author == null || content == null ) {
			request.setAttribute("error", "書き込みに失敗しました"); 
		} else if( content.equals("")){
			request.setAttribute("error", "本文を入力してください"); 
		} else {
			Connection con = null;
			try {
				con = dm.ConnectionManager.getConnection();
				ResDAO resdao = new ResDAO(con);
				Res res = new Res(author, content);
				res = resdao.insert(res);
				if(res != null) {
					request.setAttribute("res", res);
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
