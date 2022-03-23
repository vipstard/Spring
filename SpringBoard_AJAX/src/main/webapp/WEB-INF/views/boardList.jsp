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
</head>
<body>

	<div class="container">
		<h2>Spring WEB MVC 게시판</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Panel Heading</div>
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
	function loadList(){
	   $.ajax({
	      url : "/myapp1/boardList.do",
	      type : "get",
	      dataType: "json", //json으로 받음
	      success : htmlView,
	      error : function(){
	         alert("error")
	      }
	   })
	}
	function htmlView(data){
		var result = "<table class='table table-bordered table-hover'>"
			  
			result += "<tr>"
				 result += "<th>번호</th>"
			     result += "<th>제목</th>"
			     result += "<th>작성자</th>"
		   	     result += "<th>작성일</th>"
			     result += "<th>조회수</th>"
			     result += "</tr>"
			     
			   //반복문
			   $.each(data, (index, vo)=>{
				   
				   result += "<tr>"
					      result += "<td>"+vo.idx+"</td>"
					      result += "<td id='t"+vo.idx+"'><a href='javascript:contentView("+vo.idx+")'>"+vo.title+"</a></td>"
					      result += "<td id='w"+vo.idx+"'>"+vo.writer+"</td>"
					      result += "<td>"+vo.indate+"</td>"
					      result += "<td>"+vo.count+"</td>"
					      result += "<td id='u"+vo.idx+"'><button class='btn btn-success btn-sm' onclick='goUpdate("+vo.idx+")'>수정</button></td>"
					      result += "</tr>"
					      result += "<tr style='display:none' id='cv"+vo.idx+"'>"
					      result += "<td>내용</td>"
					      result += "<td colspan='4'>"
					      result += "<textarea rows='6' class='form-control' id='c"+vo.idx+"'>"+vo.content+"</textarea>"
					      result += "<br>"
					      result += "<button class='btn-success btn-sm' onclick='updateCt("+vo.idx+")'>수정</button>&nbsp"
					      result += "<button class='btn-warning btn-sm' onclick='closeCt("+vo.idx+")'>닫기</button>"
					      result += "</td>"
					      result += "</tr>"
			     
			    
			   })
			   result += "<tr>"
			   result += "<td colspan='5'>"
			   result += "<brtton class='btn btn-primary btn-sm' onclick='goView()'>글쓰기</button>"
			   result += "</td>"
			   result += "</tr>"
			   result += "</table>"
			   $("#List").html(result)
	}
	
	/*
	function updateCt(idx){
		var content = $('#c'+idx).val()
		
		$.ajax({
	      url : "/myapp1/boardContentUpdate.do",
	      type : "post",
	      data: JSON.stringify({"idx":idx, "content":content}), //보내줄 데이터
	      contentType: "application/json",
	      success : loadList, //다시 리스트 보여지도록,
	      error : function(){
	         alert("error")
      }
   })
		*/
		
		function updateCt(idx){
			var content = $('#c'+idx).val()
			
			$.ajax({
		      url : "/myapp1/boardContentUpdate.do",
		      type : "post",
		      data: {"idx":idx, "content":content}, //보내줄 데이터
		      success : loadList, //다시 리스트 보여지도록,
		      error : function(){
		         alert("error")
	      }
	   })
	   
		
	}
	
	function contentView(idx){
		
		if($("#cv"+idx).css("display")=="none"){
		
		$("#cv"+idx).css("display", "table-row")
		}
		
		else{
			$("#cv"+idx).css("display", "none")
			
		}
	}
	
	function closeCt(idx){
		
		
		
		$("#cv"+idx).css("display", "none")
	}
	
	// 글쓰기 버튼 누르면 글쓰는 창 뜸
	function goView(){
		
		if($("#wform").css("display")=="none"){
			
			$("#wform").slideDown()
			}
			
			else{
				$("#wform").slideUp()
				
			}
		
	}

	/* 글쓰기 - 비동기 게시글 작성 */
	function goInsert(){
	
	//serialize() Ajax로 호출 하기 전 serialize를 해주면 form 안에 값들을 한번에 전송 가능한 data로 만들 수 있어서 유용
	var data = $('#frm').serialize()
	
	$.ajax({
		url : "/myapp1/boardInsert.do",
		type : "post",
		data : data,
		success : loadList,
		error : function(){
			alert("Error!")
		}
	})
	
	//$('#frm')[0].reset() 폼전체 지우기
	$("#init").trigger("click") // 취소 버튼 자동으로 눌르기 trigger("옵션")
	$("#wform").slideUp() //글쓰기 폼 숨기기

	}
	
	// 수정 버튼 클릭시 동작하는 함수
	function goUpdate(idx){
		
		//기존 제목 가져오기
		var title= $("#t"+idx).text() 
		$("#t"+idx).html("<input id='nt"+idx+"' type='text' class='form-control' value='"+title+"'>")
		
		var writer= $("#w"+idx).text() // 기존 작성자 가져오기
		$("#w"+idx).html("<input id='nw"+idx+"' type='text' class='form-control' value='"+writer+"'>")
		
		//"수정" 버튼 누른후 "수정하기" 로 변경
		var newBtn = "<button class='btn btn-info btn-sm' onclick='goUpdate1("+idx+")'>수정하기</button>"
		$("#u"+idx).html(newBtn)
	}
	
	
	
//수정하기 버튼 클릭시 동작하는 함수
function goUpdate1(idx){
	var title = $("#nt"+idx).val()
	var writer =$("#nw"+idx).val()
	
	
	//1. controller에 boardTWUpdate 메서드 만들기
	//2. mapper interface 에 boardTWUpdate() 만들기
	//3. xml update 추가
	
	$.ajax({
		url : "/myapp1/boardTWUpdate.do",
		type : "post",
		data : {"idx":idx, "title":title, "writer":writer},
		success : loadList,
		error : function(){
			alert("Error!")
		}
	})
}
		
	
	
	
	
	
	

</script>

</body>
</html>


