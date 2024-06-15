<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	ShopProductVO shopProductVO = (ShopProductVO) request.getAttribute("shopProductVO"); //ShopProductServlet.java(Concroller), �s�Jreq��shopProductVO����
%>

<html>
<head>
<title>�ӫ~��� - listOneProd.jsp</title>

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
		 <h3>�ӫ~��� - listOneProd.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/shop/product/select_page.jsp"><img src="<%=request.getContextPath()%>/shop/product/images/backbutton.png" width="50" height="50" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�ӫ~�s��</th>
		<th>�ӫ~���O</th>
		<th>�ӫ~�W��</th>
		<th>�ӫ~����</th>
		<th>�ӫ~�w��</th>
		<th>�ӫ~�إ߮ɶ�</th>
		<th>�ӫ~���A</th>


	</tr>
	<tr>

		<td width="40px">${shopProductVO.prodNo}</td>
		<td width="40px">
			<c:choose>
			    <c:when test="${shopProductVO.prodTypeNo == 1}">
			     	�]�U
			    </c:when>
			    <c:when test="${shopProductVO.prodTypeNo == 2}">
			    	�c��
			    </c:when>
			    <c:when test="${shopProductVO.prodTypeNo == 3}">
					�˳ưt��
			    </c:when>
			    <c:when test="${shopProductVO.prodTypeNo == 4}">
			     	�A��
			    </c:when>
			</c:choose>
		</td>
		<td>${shopProductVO.prodName}</td>
		<td>${shopProductVO.prodInfo}</td>
		<td width="70px">$ ${shopProductVO.prodPrice}</td>
		<td width="100px">${shopProductVO.prodDate}</td>
		<td width="40px">${shopProductVO.prodStatus == '0' ? '�U�[' : '�W�['}</td>
  
	</tr>
</table>

</body>
</html>