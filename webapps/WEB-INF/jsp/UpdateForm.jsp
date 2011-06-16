<%@ page contentType="text/html; charset=utf8"%>
<%@ page import="java.util.Calendar" %>
<html>
    <head>
        <title>ユーザー情報変更</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>ユーザー情報変更</h1>
        <form action="app/UserModifyAction" method="post">
            <p>名前：<input type="text" name="name" value="<%= session.getAttribute("user") %>"></p>
            <p>パスワード：<input type="password" name="password" ></p>
            <p>新しいパスワード：<input type="password" name="password" value=""></p>

            <p>生年月日：
            <select name="birthyear">
                <%
                for(int i=1900;i<=2020;i++) {
                %>
                <% if(i==((Calendar)session.getAttribute("birthday")).get(Calendar.YEAR)) { %>
                    <option value="<%= i %>" selected><%= i %></option>
                    <% } else { %>
                    <option value="<%= i %>"><%= i %></option>
                    <%= ((Calendar)session.getAttribute("birthday")).get(Calendar.YEAR) %>
                    <% } %>
                <% } %>
            </select>
            <select name="birthmonth">
                <%
                for(int i=1;i<=12;i++) {
                %>
                <% if(i==((Calendar)session.getAttribute("birthday")).get(Calendar.MONTH)+1) { %>
                <option value="<%= i %>" selected><%= i %></option>
                <% } else { %>
                <option value="<%= i %>"><%= i %></option>
                <% } %>
                <% } %>
            </select>
            <select name="birthday">
                <%
                for(int i=1;i<=31;i++) {
                %>
                <% if(i==((Calendar)session.getAttribute("birthday")).get(Calendar.DAY_OF_MONTH)) { %>
                <option value="<%= i %>" selected><%= i %></option>
                <% } else { %>
                <option value="<%= i %>"><%= i %></option>
                <% } %>
                <% } %>
            </select>
            </p>

            <p><input type="submit" value="書き込み"></p>
        </form>
    </body>
</html>
