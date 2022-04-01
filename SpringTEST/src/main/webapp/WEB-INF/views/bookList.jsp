<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Spring Book</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    	SMHRD 도서관
    </div>
    <div class="panel-body">
    	<table class="table table-hover table-bordered">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작가</td>
				<td>출판사</td>
				<td>ISBN</td>
				<td>보유도서</td>
			</tr>
			<!-- JSTL/EL 반복문 사용해서 번호, 제목, 작가, 출판사, ISBN, 보유도서 수, 삭제 버튼 테이블에 출력 -->
			<c:forEach var="vo" items="${list}">
			   <tr>
			   	  <td>${vo.num}</td>
			      <td>${vo.title}</a></td>
			      <td>${vo.author}</td>
			      <td>${vo.company}</td>
			      <td>${vo.isbn}</td>
			      <td>${vo.count}</td>
			      
   		<td>
   			<button class="btn btn-success btn-sm" onclick="location.href='/SpringTEST/bookDelete.do/${vo.num}'">삭제</button>
   		</td>
  
			   </tr>
			   
			   </c:forEach>
			<tr>
				<td colspan="5">
					<button class="btn btn-info btn-sm" onclick="loadList()">Ajax로 리스트 불러오기</button>
				</td>
			</tr>
		</table> 
    </div>
    <div class="panel-body" id="list"></div>
    <div class="panel-footer">SMHRD 도서관</div>
  </div>
</div>

<script>


	
	function loadList(){
		$.ajax({
			url : "/SpringTEST/boardListAjax.do",
			type : "get",
			dataType : "json",
			success : htmlView,
			error : function(){
				alert("error")
			}
		})
	}
	function htmlView(data){
		var result = "<table class='table table-bordered table-hover'>";
		result += "<tr>";
		result += "<td>번호</td>";
		result += "<td>제목</td>";
		result += "<td>작가</td>";
		result += "<td>출판사</td>";
		result += "<td>ISBN</td>";
		result += "<td>보유도서</td>";
		result += "</tr>";
		//반복문 사용해서 번호,제목,작가,출판사,ISBN,보유도서 수 테이블에 출력
		$.each(data, (index, vo)=>{
				   
				   result += "<tr>"
					      result += "<td>"+vo.num+"</td>"
					      result += "<td>"+vo.title+"</a></td>"
					      result += "<td>"+vo.author+"</td>"
					      result += "<td>"+vo.company+"</td>"
					      result += "<td>"+vo.isbn+"</td>"
					      result += "<td>"+vo.count+"</td>"
					      result += "</tr>"
			     
			    
			   })
		result += "</table>";
		//아이디가 list인 곳에 result 값(html) 추가
		$("#list").html(result)
	} 
</script>
</body>
</html>





