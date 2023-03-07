<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ include file="../include/sidebar.jsp" %>
<%@ include file="../include/top.jsp" %>

<form action="noticeAdd.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td>제목</td><td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>작성자</td><td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea rows="5" cols="30" name="subject"></textarea></td>
		</tr>
		<tr>
			<td>첨부파일</td><td><input type="file" name="attach"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장">
			</td>
		</tr>
	</table>	
</form>
<%@ include file="../include/footer.jsp" %>