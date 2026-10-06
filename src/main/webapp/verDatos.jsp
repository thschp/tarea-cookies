<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Datos</title>
</head>
<body>
	<h2>Lista de datos</h2>
	<%
		List<Cookie> cookies = (List<Cookie>) request.getAttribute("listaCookies");
    	if (cookies != null && !cookies.isEmpty()) {
    %>
    <details>
    	 <summary><b>Haz clic aquí para ver los datos</b></summary>
    	<ul>
       	 	<%
            	for (Cookie c : cookies) {
        	%>
            	<li><strong><%= c.getName() %>:</strong> <%= c.getValue() %></li>
        	<%
            	}
        	%>
        </ul>
	</details>
    <%
        } else {
    %>
        <p>ERROR: No hay datos disponibles.</p>
    <%
        }
    %>
    <form action='Servlet2' method='post'>
		<input type='submit' value='GO'>
	</form>
</body>
</html>