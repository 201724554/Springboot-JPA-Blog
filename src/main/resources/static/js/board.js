let index = {
	//let _this = this;
	init: function(){
		$("#btn-save").on("click",()=>{ //function 사용 x, this를 바인딩하기 위해 ()=> 사용, function 쓰니까 에러 뜨더라
			this.save();
		});
		$("#btn-delete").on("click",()=>{ //function 사용 x, this를 바인딩하기 위해 ()=> 사용, function 쓰니까 에러 뜨더라
			this.deleteById();
		});
		$("#btn-update").on("click",()=>{ //function 사용 x, this를 바인딩하기 위해 ()=> 사용, function 쓰니까 에러 뜨더라
			this.update();
		});
			//_this.save(); 위에 function 쓰는 경우는 이렇게 
	},
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};
		
		$.ajax({
			type:"POST",
			url:"/api/board",
			data:JSON.stringify(data),
			contentType:"application/json;charset=UTF-8", //body data의 type
			dataType:"json" //응답의 type
		}).done(function(res){ 
			alert("글쓰기 완료 " + res);
			location.href = "/";
			//ajax 정상적으로 수행되면 done()
		}).fail(function(error){ //response의 type이 json이므로 JSON.stringify json이 아니면 그대로 
			alert(JSON.stringify(error));
			//실패하면 fail()
		});
	},
	
	deleteById: function(){
		let id = $("#id").text();
		
		$.ajax({
			type:"DELETE",
			url:"/api/board/"+id,
			dataType:"json" //응답의 type
		}).done(function(res){ 
			alert("삭제 완료 " + res);
			location.href = "/";
			//ajax 정상적으로 수행되면 done()
		}).fail(function(error){ //response의 type이 json이므로 JSON.stringify json이 아니면 그대로 
			alert(JSON.stringify(error));
			//실패하면 fail()
		});
	},
	
	update: function(){
		let id = $("#id").val();
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};
		
		$.ajax({
			type:"PUT",
			url:"/api/board/"+id,
			data:JSON.stringify(data),
			contentType:"application/json;charset=UTF-8", //body data의 type
			dataType:"json" //응답의 type
		}).done(function(res){ 
			alert("수정 완료 " + res);
			location.href = "/";
			//ajax 정상적으로 수행되면 done()
		}).fail(function(error){ //response의 type이 json이므로 JSON.stringify json이 아니면 그대로 
			alert(JSON.stringify(error));
			//실패하면 fail()
		});
	}
}


index.init();