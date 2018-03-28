
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New News</title>
	<script src="static/ckeditor/ckeditor.js"></script>
	<script src="static/ckfinder/ckfinder.js"></script>
</head>
<body style="background:#f1f1f1">
	
	<div style="width:80%; margin:auto;">
		<p style="color:#139ff7; text-align:center;font-size:30px;"><b>CREATE NEW NEWS</b></p>
		
		<form method="POST" action="save-news">
			<input type="hidden" name="news_id" value="${news.news_id}"/>
			<p >Title:</p>
			<input type="text" style="width:50%;" value="${news.title}" name="title" required/>
			<p>Content:</p>
            <textarea id="content" id="content" name="content" required>
                ${news.content}
            </textarea>
            <button type="submit" style="padding:5px 10px 5px 10px;margin-top:10px;background-color:#139ff7;">Create</button>
        </form>
        <script>
		CKEDITOR.replace('content');
		</script>
	</div>
	
</body>
</html>