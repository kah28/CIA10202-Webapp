package com.shop.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.ShopProductService;
import com.shop.model.ShopProductVO;


public class ShopProductServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doPost(req, res);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("prodNo");
			if(str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入商品編號");
			}
			
			// Send the use back to the form, if there were errors
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/select_page.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			Integer prodNo = null;
			try {
				prodNo = Integer.valueOf(str);				
			} catch (Exception e) {
				errorMsgs.add("商品編號格式不正確");
			}
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/select_page.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ShopProductService shopProductSvc = new ShopProductService();
			ShopProductVO shopProductVO = shopProductSvc.getOneProdNo(prodNo);
			if(shopProductVO == null) {
				errorMsgs.add("查無此筆資料");
			}
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/select_page.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("shopProductVO", shopProductVO);
			String url = "/shop/product/listOneProd.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneProd.jsp
			successView.forward(req, res);
	
			
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllProd.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數****************************************/
			Integer prodNo = Integer.valueOf(req.getParameter("prodNo"));
			
			/***************************2.開始查詢資料****************************************/
			ShopProductService shopProductSvc = new ShopProductService();
			ShopProductVO shopProductVO = shopProductSvc.getOneProdNo(prodNo);			
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("shopProductVO", shopProductVO); // 資料庫取出的ShopProductVO物件,存入req
			String url = "/shop/product/update_Prod_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_Prod_input.jsp
			successView.forward(req, res);
		
		}
		
		if("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
			//商品編號 (不可編輯)
			Integer prodNo = Integer.valueOf(req.getParameter("prodNo").trim());
			
			//商品類別編號	
			Integer prodTypeNo = null;
			try {
				prodTypeNo = Integer.valueOf(req.getParameter("prodTypeNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("商品類別編號請填整數");
			}
			
			//商品名稱 ?字數限制100
			String prodName = req.getParameter("prodName").trim();
			if (prodName == null || prodName.trim().length() == 0) {
				errorMsgs.add("商品名稱請勿空白");
			}	
			
			//商品介紹 ?字數限制1000
			String prodInfo = req.getParameter("prodInfo").trim();
			if (prodName == null || prodName.trim().length() == 0) {
				errorMsgs.add("商品介紹請勿空白");
			}
			
			//商品定價
			Integer prodPrice = null;
			try {
				prodPrice = Integer.valueOf(req.getParameter("prodPrice").trim());
			} catch (NumberFormatException e) {
				prodPrice = 0;
				errorMsgs.add("商品定價請填整數");
			}

			//商品狀態 只能是0 or 1
			Integer prodStatus = null;
			try {
				prodStatus = Integer.valueOf(req.getParameter("prodStatus").trim());		
			} catch (NumberFormatException e) {
				prodStatus = 0; //?
				errorMsgs.add("商品狀態僅能為0(下架)或1(上架)");
			}
			
			//商品建立時間
			Timestamp prodDate = new Timestamp(System.currentTimeMillis());

			
			ShopProductVO shopProductVO = new ShopProductVO();
			
			shopProductVO.setProdNo(prodNo);
			shopProductVO.setProdName(prodName);
			shopProductVO.setProdTypeNo(prodTypeNo);
			shopProductVO.setProdInfo(prodInfo);
			shopProductVO.setProdPrice(prodPrice);
			shopProductVO.setProdStatus(prodStatus);
			shopProductVO.setProdDate(prodDate);
			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shopProductVO", shopProductVO); // 含有輸入格式錯誤的shopProductPicVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/update_Prod_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷	
			}
			/***************************2.開始修改資料*****************************************/
			ShopProductService shopProductSvc = new ShopProductService();
			shopProductVO = shopProductSvc.updateProduct(prodTypeNo, prodName,prodInfo, prodPrice, prodStatus, prodDate, prodNo);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("shopProductVO", shopProductVO); // 資料庫update成功後,正確的的shopProductVO物件,存入req
			String url = "/shop/product/listOneProd.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneProd.jsp
			successView.forward(req, res);
			
		}
		
		
        if ("insert".equals(action)) { // 來自addProd.jsp的請求
        
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
        
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
			//商品類別編號	
			Integer prodTypeNo = null;
			try {
				prodTypeNo = Integer.valueOf(req.getParameter("prodTypeNo"));
			} catch (NumberFormatException e) {
				prodTypeNo = 0;
				errorMsgs.add("商品類別編號請填整數");
			}
			
			//商品名稱 ?字數限制100
			String prodName = req.getParameter("prodName").trim();
			if (prodName == null || prodName.trim().length() == 0) {
				errorMsgs.add("商品名稱請勿空白");
			}	
			
			//商品介紹 ?字數限制1000
			String prodInfo = req.getParameter("prodInfo").trim();
			if (prodInfo == null || prodInfo.trim().length() == 0) {
				errorMsgs.add("商品介紹請勿空白");
			}
			
			//商品定價
			Integer prodPrice = null;
			try {
				prodPrice = Integer.valueOf(req.getParameter("prodPrice").trim());
			} catch (NumberFormatException e) {
				prodPrice = 0;
				errorMsgs.add("商品定價請填整數");
			}

			//商品狀態 只能是0 or 1
			Integer prodStatus = null;
			try {
				prodStatus = Integer.valueOf(req.getParameter("prodStatus").trim());		
			} catch (NumberFormatException e) {
				prodStatus = 0; //?
				errorMsgs.add("商品狀態僅能為0(下架)或1(上架)");
			}
			
			//商品建立時間
			Timestamp prodDate = new Timestamp(System.currentTimeMillis());

			
			ShopProductVO shopProductVO = new ShopProductVO();
			
		
			shopProductVO.setProdName(prodName);
			shopProductVO.setProdTypeNo(prodTypeNo);
			shopProductVO.setProdInfo(prodInfo);
			shopProductVO.setProdPrice(prodPrice);
			shopProductVO.setProdStatus(prodStatus);
			shopProductVO.setProdDate(prodDate);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shopProductVO", shopProductVO); // 含有輸入格式錯誤的shopProductVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/update_Prod_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷	
			}
        
			/***************************2.開始新增資料***************************************/
			ShopProductService shopProductSvc = new ShopProductService();
			shopProductVO = shopProductSvc.addProduct(prodTypeNo, prodName, prodInfo, prodPrice, prodStatus, prodDate);
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/shop/product/listAllProd.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllProd.jsp
			successView.forward(req, res);
        }
        
		if ("delete".equals(action)) { // 來自listAllProd.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			/***************************1.接收請求參數***************************************/
			
			Integer prodNo = Integer.valueOf(req.getParameter("prodNo"));
			/***************************2.開始刪除資料***************************************/
			ShopProductService shopProductSvc = new ShopProductService();
			shopProductSvc.deleteProduct(prodNo);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/shop/product/listAllProd.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	
	}
		
}
