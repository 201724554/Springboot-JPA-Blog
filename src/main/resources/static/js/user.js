let index = {
	//let _this = this;
	init: function(){
		$("#btn-save").on("click",()=>{ //function 사용 x, this를 바인딩하기 위해 ()=> 사용, function 쓰니까 에러 뜨더라
			this.save();
		});
			//_this.save(); 위에 function 쓰는 경우는 이렇게 
	},
	save: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),
			contentType:"application/json;charset=UTF-8", //body data의 type
			dataType:"json" //응답의 type
		}).done(function(res){ //응답의 결과가 매개변수로 전달됨, 지금 경우는 /api/user 매핑을 가지는 메소드의 리턴 값 1
			alert("회원가입 완료 " + res);
			location.href = "/";
			//ajax 정상적으로 수행되면 done()
		}).fail(function(error){ //response의 type이 json이므로 JSON.stringify json이 아니면 그대로 
			alert(JSON.stringify(error));
			//실패하면 fail()
		});
	}
}


index.init();