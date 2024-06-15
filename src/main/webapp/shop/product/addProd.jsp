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
<title>商品新增 - addProd.jsp</title>

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
		 <h3>商品新增 - addProd.jsp</h3></td><td>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/shop/product.do" name="form1">
<table>

	<tr>
		<td>商品類別:<font color=red><b>*</b></font></td>
		<td><select size="1" name="prodTypeNo">
	        <option value="1">包袋</option>
	        <option value="2">鞋類</option>
	        <option value="3">裝備配件</option>
	        <option value="4">服飾</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>商品名稱:</td>
		<td><input type="TEXT" name="prodName" value="" size="45"/></td>
	</tr>
	
	<tr>
		<td>定價:</td>
		<td><input type="TEXT" name="prodPrice" value="" size="45"/></td>
	</tr>
	
	<tr>
		<td>商品介紹:</td>
		<td><textarea name="prodInfo" value="" style="width: 335px; max-width: 335px; height: 100px;"/></textarea>
	</tr>

	<tr>
		<%
	    Timestamp currentTimestamp = new Timestamp(new Date().getTime());
		%>
		<td>建立日期:</td>
		<td><input type="TEXT" name="prodDate" value="<%= currentTimestamp %>"></td>
	</tr>

	

</table>
<br>

<input type="hidden" name="action" value="insert">
<input type="hidden" name="prodStatus" value="0">
<input type="submit" value="送出新增"></FORM>

</body>




</html>