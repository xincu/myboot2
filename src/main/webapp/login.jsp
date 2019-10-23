<%--
  Created by IntelliJ IDEA.
  User: 周Cu
  Date: 2019/8/29
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="login"method="post">
    <jsp:include page="token.jsp"></jsp:include>
    <p>用户：<input type="text" name="user"></p>

    <p>密码：<input type="password" name="password"></p>
   <input type="submit" value="提交">
</form>
</body>
</html>
