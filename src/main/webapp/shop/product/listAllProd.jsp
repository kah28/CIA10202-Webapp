<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shop.model.*"%>

<%   
    ShopProductService shopProductSvc = new ShopProductService();
    List<ShopProductVO> list = shopProductSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有商品資訊 - listAllProd.jsp</title>

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
	width: 800px;
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
		 <h3>所有商品資訊 - listAllProd.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/backbutton.png" width="60" height="60" border="0">回首頁</a></h4>
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
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="shopProductVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
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

			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/shop/product.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="prodNo"  value="${shopProductVO.prodNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/shop/product.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="prodNo"  value="${shopProductVO.prodNo}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>