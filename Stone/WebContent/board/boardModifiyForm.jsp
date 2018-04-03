<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정 폼</title>
<style text="text/css">
	* {font-size:9pt;}
	p {width: 600px; text-align: right;'}
	table tbody tr th {background-color:gray;}
</style>
<script type="text/javascript">
	function goUrl(url) {
		location.href=url;
	}
	
	function boardModifyCheck(){
		var form = document.boardModifyForm;
		return true;
	}
</script>
</head>
<body>
	<form name="boardModifyForm" action="boardProcess.jsp" method="post" onsubmit="return boardModifyCheck();">
	<input type="hidden" name="mode" value="M" />
	<table border="1" summary="게시판 수정 폼">
		<caption>게시판 수정 폼</caption>
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th align="center">제목</th>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<th align="center">작성자</th>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="" cols=""></textarea></td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록" onclick="goUrl('boardList.jsp');" />
		<input type="submit" value="글수정" />
	</p>
	</form>
</body>
</html>