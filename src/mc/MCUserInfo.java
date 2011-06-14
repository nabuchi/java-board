package mc;
import java.util.*;
import java.sql.*;
import bean.UserInfo;
import dao.UserInfoDAO;
import dm.ConnectionManager;
public class MCUserInfo{

	private MCUserInfo(){}

	public static UserInfo login(String userId, String password){
        Connection con = null;
        UserInfo user = null;
        try {
            con = dm.ConnectionManager.getConnection();
            UserInfoDAO userdao = new UserInfoDAO(con);
            user = userdao.selectByNamePass(userId, password);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(con != null) { con.close(); }
            }catch(Exception e) {}
        }
        return user != null ? user : null;
	}
}
