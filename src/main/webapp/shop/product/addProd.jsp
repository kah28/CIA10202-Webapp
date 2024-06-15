<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>

<% 
   ShopProductVO shopProductVO = (ShopProductVO) request.getAttribute("shopProductVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�ӫ~�s�W - addProd.jsp</title>

<style>
  table#table-1 {
	background-color: #90C320;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>�ӫ~�s�W - addProd.jsp</h3></td><td>
		 <h4><a href="select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/shop/product.do" name="form1">
<table>

	<tr>
		<td>�ӫ~���O:<font color=red><b>*</b></font></td>
		<td><select size="1" name="prodTypeNo">
	        <option value="1">�]�U</option>
	        <option value="2">�c��</option>
	        <option value="3">�˳ưt��</option>
	        <option value="4">�A��</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>�ӫ~�W��:</td>
		<td><input type="TEXT" name="prodName" value="" size="45"/></td>
	</tr>
	
	<tr>
		<td>�w��:</td>
		<td><input type="TEXT" name="prodPrice" value="" size="45"/></td>
	</tr>
	
	<tr>
		<td>�ӫ~����:</td>
		<td><textarea name="prodInfo" value="" style="width: 335px; max-width: 335px; height: 100px;"/></textarea>
	</tr>

	<tr>
		<%
	    Timestamp currentTimestamp = new Timestamp(new Date().getTime());
		%>
		<td>�إߤ��:</td>
		<td><input type="TEXT" name="prodDate" value="<%= currentTimestamp %>"></td>
	</tr>

	

</table>
<br>

<input type="hidden" name="action" value="insert">
<input type="hidden" name="prodStatus" value="0">
<input type="submit" value="�e�X�s�W"></FORM>

</body>




</html>