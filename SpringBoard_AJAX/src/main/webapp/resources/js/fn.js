		
		
		
		function getContextPath(){
		var hostIndex = location.href.indexOf(location.host)+location.host.lehth;
		var contextPath = location.href.substring(hostIndex, location.href.indexOf("/", hostIndex+1))
		return contextPath
		}
		
		
		function loadList(){
	   $.ajax({
	      url : getContextPath()+ "boardList.do",
	      type : "get",
	      dataType: "json", //json으로 받음
	      success : htmlView,
	      error : function(){
	         alert("error")
	      }
	   })
	}
	
	
	
	/*
	function updateCt(idx){
		var content = $('#c'+idx).val()
		
		$.ajax({
	      url : getContextPath()+ "boardContentUpdate.do",
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
		      url : getContextPath()+ "boardContentUpdate.do",
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
		

function goDelete(idx){
	   $.ajax({
	      url : "/myapp1/boardDelete.do",
	      type : "get",
	      data: {"idx":idx},
	      success : loadList,
	      error : function(){
	         alert("error")
	      }
	   })
	}
	
function logout(){
	location.href="/myapp1/logout.do"


	}
	
	