<%@ page import="java.util.UUID" %><%--
  Created by IntelliJ IDEA.
  User: 周Cu
  Date: 2019/8/29
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String  token= UUID.randomUUID().toString();
    token =token.replace("-","");
    session.setAttribute("token",token);
%>
<input type="hidden" name ="token" value="<%=token%>"/>