<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isErrorPage="true" import="java.io.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote no livro - Pagina de erro</title>
</head>
<br>
<body>  

<p>Ocorreu um erro, detalhes do erro:</p>
<% if(exception!=null){%>
<div>  
        <div><%= exception.toString() %><br>  </div>  
  
                    <%  
                    out.println("<!--");  
                    StringWriter sw = new StringWriter();  
                    PrintWriter pw = new PrintWriter(sw);  
                    exception.printStackTrace(pw);  
                    out.print(sw);  
                    sw.close();  
                    pw.close();  
                    out.println("-->");  
                    %>  
</div>  
        <% }%>  
</body>  


</html>