<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电子打卡</title>
</head>
<body>
<%@include file="../header.jsp" %>
<%@include file="empheader.jsp" %>
<table width="780" align="center" background="${pageContext.request.contextPath }/images/bodybg.jpg">
	<tr>
		<td colspan="3"><br/><br/><div class="mytitle">电子打卡系统</div>
	</td>
	<tr co;span="3" style="text-align:center;">
	<br/><br/><br/>
	<s:if test="punchIsValid==1 || punchIsValid==3">
	<s:form action="employeecome" theme="simple">
		<s:submit key="come.punch"/>
	</s:form>
	</s:if>
	<s:if test="punchIsValid==2 || punchIsvalid==3">
	<s:form action="employeeLeave" theme="simple">
	<s:hidden value="leave"/>
	</s:form>
	</s:if>
</table>
<%@include file="../footer.jsp" %>
</body>
</html>