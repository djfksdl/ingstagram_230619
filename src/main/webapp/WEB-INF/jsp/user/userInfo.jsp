<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="d-flex justify-content-center">

	<div class="user-info-box">
	<h1 class="m-4 font-weight-bold">개인정보 수정</h1>
	<form method="post" action="/user/user-info" class="bg-light p-5">
		<span>Name : </span>
		<div class="d-flex mt-3">
			<input type="text" class="form-control col-8 mr-2" placeholder=${userName}>
			<button type="button" id="nameChangeBtn" class="btn btn-success">수정완료</button>
		</div>
		
		<span>Email : </span>
		<div class="d-flex mt-3">
			<input type="text" class="form-control col-8 mr-2" placeholder=${userName}>
			<button type="button" id="emailChangeBtn" class="btn btn-success">수정완료</button>
		</div>
		
		<span>프로필사진 :</span>
		<div class="d-flex justify-content-between">
			<div class="file-upload d-flex mt-3">
				<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg" class="d-none">
				<a href="#" id="fileUploadBtn"><img width="35" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"></a>
				<div id="fileName" class="ml-2"></div>
			</div>
			<button id="writeBtn" class="btn btn-success">게시</button>
		</div>
	</form>
	</div>
</div>
<script>
	$(document).ready(function(){
		//네임 수정
		$("#nameChangeBtn").on('click', function(){
			 var newName = $('input[placeholder=${userName}]').val();
		})
		
		$.ajax({
			//request
			type:"put"
			,url:"/user/update"
			,data:formData
			,enctype:"multipart/form-data"
			, processData:false
			, contentType:false
			
			//response
			,success:function(data){
				if(data.result =="성공"){
					alert("메모가 수정되었습니다.");
					location.reload(true);
				} else{
					//로직 실패
					alert(data.errorMessage);
				}
			}
		,error:function(request, status, error){
			alert("글을 저장하는데 실패했습니다.");
		}
		})
		
		//이메일 수정
		$("#emailChangeBtn").on('click', function(){
			alert("클릭");
		})
	});
</script>