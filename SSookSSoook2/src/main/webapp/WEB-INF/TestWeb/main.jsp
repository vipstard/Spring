<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <button type="button" class="btn" onclick="location.href='/TEST/productList'">제품구매</button>
    <button type="button" class="btn" onclick="location.href='/TEST/helpDesk'">고객센터</button>
	<button class="btn btn-default btn-sm" onclick="location.href='https://kauth.kakao.com/oauth/logout?client_id=e3eced6c366d05e611468e218fc8f42d&logout_redirect_uri=http://localhost:8081/TEST/LogOut'">LogOut</button>
	<button class="btn btn-default btn-sm" onclick="location.href='/TEST/EditProfile'">Edit Profile</button>
	<button class="btn btn-default btn-sm" onclick="location.href='/TEST/member_Manage'">Management</button>
	<button type="button" class="btn" onclick="location.href='/TEST/JoinForm'">Join</button>
    <button type="button" class="btn" onclick="location.href='/TEST/Login'">Login</button>
     

</body>
</html>