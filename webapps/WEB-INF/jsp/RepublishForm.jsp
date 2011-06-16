<%@ page contentType="text/html; charset=utf8"%>
<%@ page import="java.util.Calendar" %>
<html>
    <head>
        <title>パスワード再発行</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>パスワード再発行</h1>
        <form action="app/RepublishAction" method="post">
            <p>名前：<input type="text" name="name"></p>
            <p>新しいパスワード：<input type="password" name="newpassword"></p>
        <p>生年月日：
        <select name="birthyear">
            <%
            for(int i=1900;i<=2020;i++) {
            %>
            <option value="<%= i %>"><%= i %></option>
            <% } %>
        </select>
        <select name="birthmonth">
            <%
            for(int i=1;i<=12;i++) {
            %>
            <option value="<%= i %>"><%= i %></option>
            <% } %>
        </select>
        <select name="birthday">
            <%
            for(int i=1;i<=31;i++) {
            %>
            <option value="<%= i %>"><%= i %></option>
            <% } %>
        </select>
        </p>
        <p><input type="submit" value="再発行"></p>
    </form>
    </body>
</html>


