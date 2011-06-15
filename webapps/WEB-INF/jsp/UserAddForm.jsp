<%@ page contentType="text/html; charset=utf8"%>
<html>
    <head>
        <title>トピック作成</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>ログインフォーム</h1>
        <form action="app/UserAddAction" method="post">
            <p>名前：<input type="text" name="name"></p>
            <p>パスワード：<input type="password" name="password"></p>
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
            <p><input type="submit" value="登録"></p>
        </form>
    </body>
</html>
