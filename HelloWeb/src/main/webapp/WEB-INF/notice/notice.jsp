<%@page import="co.dev.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ include file="../include/sidebar.jsp" %>
<%@ include file="../include/top.jsp" %>

<%
	NoticeVO vo = (NoticeVO) request.getAttribute("notice");
%>

<form action="noticeAdd.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td>글번호</td>
			<td><input type="text" name="title" readonly value="<%=vo.getNoticeId()%>"></td>
			<td>조회수 <b><%=vo.getHitCount() %></b></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan=2><input type="text" name="title" value="<%=vo.getNoticeTitle()%>"></td>
			<td>작성자</td><td><input type="text" name="writer" value="<%=vo.getNoticeWriter()%>"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="2"><textarea rows="5" cols="30" name="subject"><%=vo.getNoticeSubject()%>"></textarea></td>
		</tr>
		<tr>
			<td>파일</td>
			<%=if(vo.getAttach() != null) { %>
				<input type="text" name="attach" value=""></td>
			<% else %>
		</tr>
		<tr>						
			<td colspan="2" align="center">
				<input type="submit" value="저장">
			</td>
		</tr>
	</table>	
</form>
<%@ include file="../include/footer.jsp" %>