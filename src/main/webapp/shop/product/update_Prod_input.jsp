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
<title>�ӫ~�ק� - update_Prod_input.jsp</title>

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
	width: 700px;
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
		 <h3>�ӫ~�ק� - update_Prod_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/shop/product/listAllProd.jsp"><img src="<%=request.getContextPath()%>/shop/product/images/backbutton.png" width="50" height="50" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

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
		<td>�ӫ~�s��:</td>
		<td>${shopProductVO.prodNo}</td>
	</tr>

	<tr>
		<td>�ӫ~���O:</td>
		<td><select size="1" name="prodTypeNo">
	        <option value="1" ${shopProductVO.prodTypeNo == '1' ? 'selected' : ''}>�]�U</option>
	        <option value="2" ${shopProductVO.prodTypeNo == '2' ? 'selected' : ''}>�c��</option>
	        <option value="3" ${shopProductVO.prodTypeNo == '3' ? 'selected' : ''}>�˳ưt��</option>
	        <option value="4" ${shopProductVO.prodTypeNo == '4' ? 'selected' : ''}>�A��</option>
		</select></td>
	</tr>
	
	<tr>
		<td>�ӫ~�W��:</td>
		<td><input type="TEXT" name="prodName" value="${shopProductVO.prodName}" size="45"/></td>
	</tr>
	
	<tr>
		<td>�w��:</td>
		<td><input type="TEXT" name="prodPrice" value="${shopProductVO.prodPrice}" size="45"/></td>
	</tr>
	
	<tr>
		<td>�ӫ~����:</td>
		<td><textarea name="prodInfo" style="width: 400px; max-width: 500px; height: 100px;">${shopProductVO.prodInfo}</textarea></td>
	</tr>

	<tr>
	<%
    Timestamp currentTimestamp = new Timestamp(new Date().getTime());
	%>
		<td>�إߤ��:</td>
		<td><input type="TEXT" name="prodDate" id="f_date1" value="${shopProductVO.prodDate}"></td>
	</tr>

	<tr>
		<td>�ӫ~���A:<font color=red><b>*</b></font></td>
		<td><select size="1" name="prodStatus">
	        <option value="0">�U�[</option>
	        <option value="2">�W�[</option>
			</select>
		</td>
	</tr>

</table>
<br>
<input type="hidden" name="prodNo" value="${shopProductVO.prodNo}">
<input type="hidden" name="action" value="update">
<input type="submit" value="�e�X�ק�"></FORM>

<% 
  java.sql.Timestamp prodDate = null;
  try {
	    prodDate = shopProductVO.getProdDate();
   } catch (Exception e) {
	   prodDate = new java.sql.Timestamp(System.currentTimeMillis());
   }
%>

<script>
        
</script>
</body>


</html>