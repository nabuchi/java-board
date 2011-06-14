package dao;

import java.sql.*;
import java.util.*;
import bean.Res;

public class ResDAO {
	private Connection con;

	public ResDAO(Connection con) {
		this.con = con;
	}

	public Res insert(Res r) throws SQLException {
        Integer id = r.getId();
        String time = r.getTime();
        Integer userid = r.getUserid();

        String idcontext = (id==-1 ? "NULL" : id.toString());
        String timecontext = (time==null ? "now()" : "'"+time+"'");
        int useridcontext = (userid==-1 ? 1 : userid);

		String sql = "insert into res values("
					+ idcontext + ",'"
                    + r.getAuthor() + "','"
					+ r.getContent() + "',"
					+ timecontext + ","
                    + useridcontext + ","
                    + r.getTopicid() + ")";
        System.out.println(sql);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql);
		if (cnt != 0) {
			return r;
		} else {
			return null;
		}
	}

	public ArrayList<Res> selectAll() throws SQLException {
		ArrayList<Res> list = new ArrayList<Res>();
		String sql = "select id, author, content, time, userid, topicid from res";
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			Res r = new Res(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
			list.add(r);
		}
		return list;
	}

    public ArrayList<Res> selectByTopicId(int topicid) throws SQLException {
		ArrayList<Res> list = new ArrayList<Res>();
		String sql = "select id, author, content, time, userid, topicid from res where topicid=" + topicid;
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
            Res r = new Res(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
            list.add(r);
        }
        return list;
    }
}
