<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.print("Hinka Patel   <br> 130050131066 <br><br><br>");
out.print("method :"+request.getMethod());
out.print("getRequestURI :"+request.getRequestURI()+ "<br>getProtocol :"+request.getProtocol()+"<br> getPathInfo :"+ request.getPathInfo()+"<br> getPathTranslated :"+request.getPathTranslated()+"<br>getQueryString :"+ request.getQueryString()+"<br>getContentLength :"+request.getContentLength()+"<br> getContentType :"+request.getContentType()+"<br>getServerName :"+request.getServerName()+"<br> getServerPort :"+ request.getServerPort()+" <br>getRemoteUser :"+request.getRemoteUser()+"<br> getRemoteAddr :"+ request.getRemoteAddr()+"<br>getRemoteHost :"+ request.getRemoteHost());
%>
</body>
</html>