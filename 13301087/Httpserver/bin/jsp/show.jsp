<%@ page language="java" contentType="text/html;charset=gb2312" import="java.text.*,java.util.*;"%>     
<html>     
<head>     
<title>Show time</title>     
</head>     
<body>      
     Hello :      
     <%     
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");     
         String str = format.format(new Date());     
      %>     
      <%=str %>     
</body>     
</html> 