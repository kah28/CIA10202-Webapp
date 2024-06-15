<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>�ӫ��ӫ~�d��: Home</title>

<Style>

  table#table-1 {
	width: 450px;
	background-color: #90C320;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: black;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
  
</Style>

</head>


<body bgcolor = 'white'>

<table id="table-1">
   <tr><td><h3>�ӫ��ӫ~�d��: ����</h3><h4>( 0201 ver. )</h4></td></tr>
</table>

<p>�����ӫ����ӫ~�d�߭���</p>

<h3>��Ƭd��:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllProd.jsp'>�C�X�Ҧ��ӫ~</a><br><br></li>



  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/shop/product.do" >
        <b>��J�ӫ~�s�� (���1.2.3...):</b>
        <br>
        <input type="text" name="prodNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>
  
    <jsp:useBean id="shopProductSvc" scope="page" class="com.shop.model.ShopProductService" />
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/shop/product.do" >
      <b>��ܰӫ~�s��:</b>
      <select size="1" name="prodNo">
        <c:forEach var="shopProductVO" items="${shopProductSvc.all}" > 
         <option value="${shopProductVO.prodNo}">${shopProductVO.prodNo}
        </c:forEach>   
      </select>
      <input type="hidden" name="action" value="getOne_For_Display">
      <input type="submit" value="�e�X">
   </FORM>
  </li>
  
</ul>


<h3>�ӫ~�޲z:</h3>

<ul>
  <li><a href='addProd.jsp'>�s�W</a>�@���s�ӫ~</li>
</ul>
  

</body>

</html>