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
            <p><input type="text" name="author"></p>
            <p><input type="text" name="content"></p>
            <p><input type="submit" value="書き込み"></p>
            <p><input type="hidden" name="topicid" value="<%= request.getParameter("topicid") %>"></p>
        </form>

        <hr />

        <%
        Iterator<Res> iter = reslist.iterator();
        while(iter.hasNext()) {
            Res res = (Res)iter.next();
        %>
        
        <p> <%= res.getAuthor() %> : <%= res.getContent() %> </p>

        <% } %>

    </body>
</html>
