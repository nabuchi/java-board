<%@ page contentType="text/html; charset=utf8"%>
<html>
    <head>
        <title>トピック作成</title>
        <base href="http://10.1.103.6:8080/java-board/"></base>
    </head>
    <body>
        <h1>ログインフォーム</h1>
        <form action="app/UserAddAction" method="post">
            <p><input type="text" name="name"></p>
            <p><input type="password" name="password"></p>
            <p><input type="text" name="secret_question"></p>
            <p><input type="text" name="secret_question_answer"></p>
            <p><input type="submit" value="登録"></p>
        </form>
    </body>
</html>
