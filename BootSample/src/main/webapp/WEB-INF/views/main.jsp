<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="loadListMyBatis()">멤버 리스트 가져오기(마이바티스)</button>
	<button onclick="loadListJPA()">멤버 리스트 가져오기(JPA)</button>
	<button onclick="loadAdmin()">id가 admin인 회원</button>

	<script>
		function loadAdmin(){
			$.ajax({
				url : "/myapp/memberJPA/admin",
				type : "get",
				data : {"id" : "admin"},
				dataType : "JSON",
				success : function(data) {
					console.log(data)
				},
				fail : function() {
					alert("ERROR")
				}
			})

		}
		
		
		function loadListMyBatis() {
			$.ajax({
				url : "/myapp/memberMB",
				type : "get",
				dataType : "JSON",
				success : function(data) {
					console.log(data)
				},
				fail : function() {
					alert("ERROR")
				}
			})

		}
		
		function loadListJPA() {
			$.ajax({
				url : "/myapp/memberJPA",
				type : "get",
				dataType : "JSON",
				success : function(data) {
					console.log(data)
				},
				fail : function() {
					alert("ERROR")
				}
			})

		}
	</script>
</body>
</html>