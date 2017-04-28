<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		/* $.ajaxSetup({  
	        contentType : 'application/json'  
	    });
		$.post('${ctx}/hello',"{name:'张三'}", function(){
			
		}); */
	});
</script>
</head>
<body>
<h1>hello, world, ${name }</h1>
<form action="${ctx}/savePerson" method="post">
	<input name="name" value=""><br/>
	<input name="age" value=""><br/>
	<input name="sex" value=""><br/>
	<input name="weight" value=""><br/>
	<input name="birthday" value=""><br/>
	<input type="submit" value="submit">
</form>
</body>
</html>