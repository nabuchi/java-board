<%@ page contentType="text/html; charset=utf8"%>
<%@ page import="bean.Res"%>
<%@ page import="java.util.Iterator"%>
<jsp:useBean id="reslist" class="java.util.ArrayList" type="java.util.ArrayList<Res>"scope="request" />
<html>
    <head>
        <title>掲示板</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        ぼでぃだよ
    <form action="app/ResAddAction" method="post">
        <p><input type="text" name="author"></p>
        <p><input type="text" name="content"></p>
        <p><input type="submit" value="書き込み"></p>
    </form>
    <hr />

    <%--
        Iterator<Res> iter = reslist.iterator();
        while(iter.hasNext()) {
            Res res = (Res)iter.next();
    --%>
    <% for(int i=0; i<reslist.size(); i++){
        Res res = (Res)reslist.get(i);
    %>
    <p><%= res.getAuthor() %>:<%= res.getContent() %></p>

    <% } %>

    </body>
</html>
