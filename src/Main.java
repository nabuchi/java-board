import dm.ConnectionManager;
import java.sql.*;
import bean.*;
import dao.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.ParseException;
import mc.MCUserInfo;


public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            //ResDAOテスト
            ResDAO rdao = new ResDAO(con);
            Res res = new Res("著者", "コメント", 1);
            rdao.insert(res);
            ArrayList<Res> rlist = rdao.selectAll();
            Iterator<Res> iter = rlist.iterator();
            while(iter.hasNext()) {
                res = iter.next();
                System.out.printf("%s %s %s %s %s\n",res.getId(), res.getTime(), res.getAuthor(), res.getContent(), res.getTopicid());
            }

            //TopicDAOテスト
            TopicDAO tdao = new TopicDAO(con);
            Topic topic = new Topic("たいとる", 1);
            tdao.insert(topic);
            ArrayList<Topic> tlist = tdao.selectAll();
            Iterator<Topic> iter2 = tlist.iterator();
            while(iter2.hasNext()) {
                topic = iter2.next();
                System.out.printf("%s %s %s %s\n",topic.getId(), topic.getTitle(), topic.getCreatedDate(), topic.getUserid());
            }

            //UserInfoDAOテスト
            /*
            UserInfoDAO udao = new UserInfoDAO(con);
            UserInfo user = new UserInfo("a"+Math.random(), "パスワード", "秘密の質問", "秘密の質問答え");
            udao.insert(user);
            ArrayList<UserInfo> ulist = udao.selectAll();
            Iterator<UserInfo> iter3 = ulist.iterator();
            while(iter3.hasNext()) {
                user = iter3.next();
                System.out.printf("%s %s %s %s\n",user.getId(), user.getName(), user.getSecretQuestion(), user.getSecretQuestionAnswer());
            }

            */
            System.out.println(333);
            System.out.println(MCUserInfo.login("aab", "aab"));
            System.out.println(333);

			UserInfoDAO userdao = new UserInfoDAO(con);
            String birthyear = "1987";
            String birthmonth = "10";
            String birthday = "24";
            String name = "nab";
            String password = "password";
            String birthdate = birthyear + "/" + birthmonth + "/" + birthday;
			UserInfo user = new UserInfo(name, password, birthdate);
			//user = userdao.insert(user);

            //Update test
            birthyear = "1900";
            birthmonth = "12";
            birthday = "1";
            name = "ttt";
            int id = 1;
            password = "qq";
            birthdate = birthyear + "/" + birthmonth  + "/" + birthday;
            user = new UserInfo(name, password, birthdate);
            userdao.updateById(1, user);

            //ByNameBirth
            UserInfo uu = new UserInfo("kkk", "ppp", "2000/1/1");
            System.out.println(userdao.selectByNameBirth(uu));

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ParseException e) {
            e.printStackTrace();
        } finally {
            try{
                if(con!=null) { con.close(); }
            }catch(Exception e){}
        }
    }
}
