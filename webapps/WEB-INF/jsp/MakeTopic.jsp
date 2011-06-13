<%@ page contentType="text/html; charset=utf8"%>
<html>
    <head>
        <title>トピック作成</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>トピック作成</h1>
        <form action="app/TopicAddAction" method="post">
            <p><input type="text" name="userid"></p>
            <p><input type="text" name="title"></p>
            <p><input type="submit" value="書き込み"></p>
        </form>
    </body>
</html>
