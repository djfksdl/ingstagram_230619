<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <h1 class="m-4 font-weight-bold d-flex justify-content-center">로그인</h1>
<div class="d-flex justify-content-center">
	
	<div class="shadow-box mb-5 bg-light">
		<div class="d-flex justify-content-center m-5  ">
			<form id="loginForm" action="/user/sign-in" method="post" >
				<%-- input-group-prepend: input box 앞에 ID 부분을 회색으로 붙인다. --%>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">ID</span>
					</div>
					<input type="text" class="form-control" name="loginId">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">PW</span>
					</div>
					<input type="password" class="form-control" name="password">
				</div>
				
				<%-- btn-block: 로그인 박스 영역에 버튼을 가득 채운다. --%>
				<input type="submit" class="btn btn-block btn-success" value="로그인">
				<a class="btn btn-block btn-dark" href="/user/sign-up-view">회원가입</a>
			</form>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		//로그인 제출
		$('#loginForm').submit(function(e){
			e.preventDefault();
			
			var loginId = $('input[name=loginId]').val().trim();
			if(loginId == ''){
				alert("아이디를 입력해주세요.");
				return;
			}
			
			var password = $('input[name=password]').val();
			if(password == ''){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			
			//AJAX로 제출
			var url = $(this).attr("action");
			var data = $(this).serialize();
			
			$.post(url, data)
			.done(function(data){
				if(data.result == "성공"){
					location.href="/timeline/timeline-view";
				} else{
					alert("로그인에 실패했습니다. 다시 시도해주세요");
				}
			})
		})
	}))
</script>