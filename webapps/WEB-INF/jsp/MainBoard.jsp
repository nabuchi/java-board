<%@ page contentType="text/html; charset=utf8" %>
<%@ page import="java.util.*" %>
<%@ page import="bean.Topic" %>
<jsp:useBean id="topiclist" class="java.util.ArrayList" scope="request" />
<html>
    <head>
        <title>掲示板</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>BBS</h1>
        <% if( session.getAttribute("loggedIn") != null ) { %>
        <p>ようこそ<%= session.getAttribute("user") %> <%= session.getAttribute("id") %>さん</p>
        <a href="app/MakeTopic">トピック作成</a>
        <a href="app/ModifyForm">会員情報変更</a>
        <a href="app/Logout">ログアウト</a>
        <% } else { %>
        <a href="app/LoginForm">ログイン</a>
        <a href="app/UserAddForm">ユーザー登録</a>
        <% } %>

    <%--
    <form action="app/ResAddAction" method="post">
        <p><input type="text" name="author"></p>
        <p><input type="text" name="content"></p>
        <p><input type="submit" value="書き込み"></p>
    </form>
    --%>
    <hr />

    <%
    Iterator<Topic> iter = topiclist.iterator();
    while(iter.hasNext()) {
        Topic topic = (Topic)iter.next();
    %>
    <p><a href="app/ResListAction?topicid=<%= topic.getId()%>"><%= topic.getTitle() %>:<%= topic.getCreatedDate() %></a><%=topic.getUserid()%></p>
    <% } %>

    <%--
    <% for(int i=0; i<mctopiclist.size(); i++){
        MCTopic mctopic = (MCTopic)mctopiclist.get(i);
        ArrayList reslist = mctopic.getResList();
    %>
    <div class="topic">
        <p><%= mctopic.getTitle() %>:<%= mctopic.getCreatedDate() %></p>
        <% for(int i=0; i<reslist.size();i++) {
        %>
        <div class="res">
            <p><%= reslist.get(i) %></p>
        </div>
        <% } %>
    </div>
    <% } %>
    --%>
    </body>
</html>
