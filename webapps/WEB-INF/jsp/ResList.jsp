<%@ page contentType="text/html; charset=utf8"%>
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
        </form>

        <hr />

    </body>
</html>
