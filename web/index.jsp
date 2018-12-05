<%--
  Created by IntelliJ IDEA.
  User: 53564
  Date: 2018/11/6
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>$Title$</title>
  </head>
  <body>
  <p>我想看看能不能显示中文</p>
  <form action="${pageContext.request.contextPath}/dataUpdate" method="post">
    <input name="searchfoodname" type="text">
    <input type="submit">

  </form>
  </body>
</html>
