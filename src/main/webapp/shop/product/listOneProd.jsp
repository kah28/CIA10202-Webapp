<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	ShopProductVO shopProductVO = (ShopProductVO) request.getAttribute("shopProductVO"); //ShopProductServlet.java(Concroller), 存入req的shopProductVO物件
%>

<html>
<head>
<title>商品資料 - listOneProd.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>商品資料 - listOneProd.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/shop/product/select_page.jsp"><img src="<%=request.getContextPath()%>/shop/product/images/backbutton.png" width="50" height="50" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>商品編號</th>
		<th>商品類別</th>
		<th>商品名稱</th>
		<th>商品介紹</th>
		<th>商品定價</th>
		<th>商品建立時間</th>
		<th>商品狀態</th>


	</tr>
	<tr>

		<td width="40px">${shopProductVO.prodNo}</td>
		<td width="40px">
			<c:choose>
			    <c:when test="${shopProductVO.prodTypeNo == 1}">
			     	包袋
			    </c:when>
			    <c:when test="${shopProductVO.prodTypeNo == 2}">
			    	鞋類
			    </c:when>
			    <c:when test="${shopProductVO.prodTypeNo == 3}">
					裝備配件
			    </c:when>
			    <c:when test="${shopProductVO.prodTypeNo == 4}">
			     	服飾
			    </c:when>
			</c:choose>
		</td>
		<td>${shopProductVO.prodName}</td>
		<td>${shopProductVO.prodInfo}</td>
		<td width="70px">$ ${shopProductVO.prodPrice}</td>
		<td width="100px">${shopProductVO.prodDate}</td>
		<td width="40px">${shopProductVO.prodStatus == '0' ? '下架' : '上架'}</td>
  
	</tr>
</table>

</body>
</html>