<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>게시판 등록 폼</title>
<style type="text/css">
	* {font-size: 9pt;}
	p {width: 600px; text-align: right;}
	table tbody tr th {background-color: gray;}
</style>
<script type="text/javascript">
	function goUrl(url) {
		location.href=url;
	}
	function boardWriteCheck() {
		var form = document.boardWriteForm;
		return true;
	}
</script>
</head>
<body>
	<form name="boardWriteForm" action="boardProcess.jsp" method="post" onsubmit="return boardWriteCheck();">
	<input type="hidden" name="mode" value="W" />
	<table border="1" summary="게시판 등록 폼">
		<caption>게시판 등록 폼</caption>
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
		<input type="submit" value="글쓰기" />
	</p>
	</form>
</body>
</html>


