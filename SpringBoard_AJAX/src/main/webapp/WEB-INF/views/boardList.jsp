<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./resources/js/fn.js"></script>
</head>
<body>

	<div class="container">
		<h2>Spring WEB MVC 게시판</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Panel Heading
			<form class="form-inline" action="/action_page.php">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
			<div class="panel-body" id="List"></div>
			<div class="panel-body" id="wform" style="display:none">
			
	<form class="form-horizontal" id="frm" method="post">
        <div class="form-group">
          <label class="control-label col-sm-2" for="title">제목:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="title" name="title" placeholder="Enter title">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="content">내용:</label>
          <div class="col-sm-10">
            <textarea rows="10" class="form-control" name="content" id='content'></textarea>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="writer">작성자:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="writer" name="writer" placeholder="Enter writer">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-success btn-sm" onclick="goInsert()">등록</button>
            <button id="init" type="reset" class="btn btn-warning btn-sm">취소</button>
          </div>
        </div>
     </form></div>
     
			<div class="panel-footer">지능형 IoT융합 SW전문가 과정</div>
		</div>
	</div>
	
	<script>
$(document).ready(()=>{
	   loadList()
	})
	
	
	
	
	

</script>

</body>
</html>


