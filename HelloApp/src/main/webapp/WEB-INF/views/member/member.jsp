<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Tiles가 적용된 member 페이지</h3>
<div>
	<table class="table">
		
			<thead>
				<tr><th>Id</th><th>Name</th><th>Pass</th><th>Mail</th><th>Auth</th></tr>
			</thead>
			<tbody>
		
			</tbody>
	<tbody id="list">
	
	</tbody>
	</table>
</div>
	<form>
		id:<input type="text" id="id""><br>
		name:<input type="text" id="name"><br>
		pass:<input type="text" id="pass"><br>
		mail:<input type="text" id="mail"><br>
		auth:<input type="text" id="auth"><br>
		<button id="addBtn">등록</button>

	</form>










<script>
	
	fetch('memberListAjax.do')	// json포맷으로 데이터 정상
	.then(function(resolve) {
		console.log(resolve); // body : readablestream 
		return resolve.json();	// json포맷에 따라 javascript object 변경
	})
	.then(function (result){
		console.log(result);	// result : 배열 [{},{},{},...{}]
		for(let i=0; i<result.length; i++){
			let id = result[i].id;
			let tr = document.createElement('tr');
			let td = document.createElement('td');
			td.innerText = id;
			tr.append(td);
		}
		let delBtn = document.createElement('button');	//<button>삭제</button>
		delBtn.innerText = '삭제';
		let td = Document.createElement('td');
		td.append(delBtn);	//<td><button>삭제</button></td>
		td.append(td);		// <tr>
		document.getElementById('list').append(tr);
	})
	.catch(function (reject){
		console.error(reject);
	})	// 예외발생시 롤백함

</script>