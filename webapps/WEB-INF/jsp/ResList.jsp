<%@ page contentType="text/html; charset=utf8"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.Res" %>
<jsp:useBean id="reslist" class="java.util.ArrayList" scope="request" />
<html>
    <head>
        <title>トピック作成</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>レス一覧</h1>
        <form action="app/ResAddAction" method="post">
            <p>名前：<input type="text" name="author"></p>
            <p><textarea name="content"></textarea></p>
            <p><input type="submit" value="書き込み"></p>
            <p><input type="hidden" name="topicid" value="<%= request.getParameter("topicid") %>"></p>
        </form>

        <hr />

        <%
        Iterator<Res> iter = reslist.iterator();
        while(iter.hasNext()) {
            Res res = (Res)iter.next();
        %>
        
        <p>名前:<%= res.getAuthor() %>  作成日:<%= res.getTime() %></p>
        <p><%= res.getContent() %></p>
        <hr />

        <% } %>

    </body>
</html>
