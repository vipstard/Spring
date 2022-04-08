<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 화면 샘플 - Bootstrap</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
	min-height: 100vh;
	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),
		to(#1d466c));
	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				
				<!-- 회원가입 폼 -->
				<form class="validation-form" action="/TEST/Join.do" method="post">
				<div class="mb-3">
						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="you@example.com"
							required>
							<font id="checkId" size="2"></font>
						<div class="invalid-feedback">이메일을 입력해주세요.</div>
					</div>
				<div class="mb-3">
						<label for="address2">비밀번호<span class="text-muted">
								</span></label> <input type="text" class="form-control" id="pw" name="pw"
							placeholder="비밀번호를 입력해주세요." required>
					</div>
				
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="name">이름</label> <input type="text"
								class="form-control" id="name" name="name" placeholder="" value="" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="nickname">별명</label> <input type="text"
								class="form-control" id="nickname" name="nick" placeholder="" value=""
								required>
							<div class="invalid-feedback">별명을 입력해주세요.</div>
						</div>
					</div>
					
					<div class="mb-3">
						<label for="address">주소</label> 
						<input type="text" class="form-control" id="address" name="address" placeholder="서울특별시 강남구" required>
						<div class="invalid-feedback">주소를 입력해주세요.</div>
					</div>
					
					<div class="row">
						<div class="col-md-8 mb-3">
							<label for="root">가입 경로</label>&nbsp;(필수아님) <select
								class="custom-select d-block w-100" id="root">
								<option value=""></option>
								<option>검색</option>
								<option>카페</option>
							</select>
							<div class="invalid-feedback">가입 경로를 선택해주세요.</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="code">추천인 코드</label>&nbsp;(필수아님)
							<input type="text" class="form-control" id="code" placeholder="" >
							<div class="invalid-feedback">추천인 코드를 입력해주세요.</div>
						</div>
					</div>
					<hr class="mb-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="aggrement"
							required> <label class="custom-control-label"
							for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
					</div>
					<div class="mb-4"></div>
					<button class="btn btn-primary btn-lg btn-block" type="submit">가입
						완료</button>
				</form><!-- 폼 끝 -->
				
			</div>
		</div>
		<footer class="my-3 text-center text-small">
			<p class="mb-1">&copy; 2022 YD</p>
		</footer>
	</div>
	<script> window.addEventListener('load', () => { 
		const forms = document.getElementsByClassName('validation-form'); 
		
		Array.prototype.filter.call(forms, (form) => { 
			form.addEventListener('submit', function (event) { 
				if (form.checkValidity() === false) 
				{ 
					event.preventDefault(); 
					event.stopPropagation(); 
				} 
				form.classList.add('was-validated'); 
				}, false); }); }, false); 
	
	</script>
	
	<script>
	
	 //버튼없이 실시간 아이디 중복체크
  	$('#email').focusout(function(){
  		let userId = $('#email').val();
  		
  		
  		if(userId==""){
  			$('#checkId').html('이메일을 입력 해 주세요.');
				$("#checkId").attr('color', 'red');
  			
  		}else if(!CheckEmail(userId)){
  			$('#checkId').html('Example@naver.com 형식에 맞게 입력해 주세요.');
			$("#checkId").attr('color', 'red');
  		
  		
  		}else{
  		$.ajax({
  				url : '../SignUpCheckCon.do',
  				type : 'post',
  				data : {userId : userId},
  				dataType : 'json',
  				
  				
  				
  				success : function(result){
  					if(result == 0 ){
  						$('#checkId').html('사용중인 이메일 입니다.');
  						$("#checkId").attr('color', 'red');
  					} else if(result==1){
  						$('#checkId').html('사용할 수 있는 이메일 입니다.');
  						$("#checkId").attr('color', 'green');
  					} 
  				},
  				error : function(){
  					alert("서버요청실패");
  				}
  		})
  		}
  	})
  	
	</script>
</body>
</html>
