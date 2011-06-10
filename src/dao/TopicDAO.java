package dao;

import java.sql.*;
import java.util.*;
import bean.Topic;

public class TopicDAO {
	private Connection con;

	public TopicDAO(Connection con) {
		this.con = con;
	}

    public Topic insert(Topic t) throws SQLException {
		String sql = "insert into topic (title, userid) values('"
                    + t.getTitle() + "',"
                    + t.getUserid() + ")";
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql);
		if (cnt != 0) {
			return t;
		} else {
			return null;
		}
    }

	public ArrayList<Topic> selectAll() throws SQLException {
		ArrayList<Topic> list = new ArrayList<Topic>();
		String sql = "select id, title, created_date, userid from topic";
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			Topic r = new Topic(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
			list.add(r);
		}
		return list;
	}
}
