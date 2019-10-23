<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<TITLE>INDEX.JSP</TITLE>
<body>
<h2>Hello World!</h2>
<h2><a hrfe="login.jsp">login</a></h2>
</body>
</html>
