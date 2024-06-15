package com.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.ShopProductPicService;
import com.shop.model.*;

@MultipartConfig
public class ShopProductPicServlet extends HttpServlet {
	
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
			String str = req.getParameter("prodPicNo");
			if(str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入商品圖片編號");
			}
			
			// Send the use back to the form, if there were errors
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/select_page.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			Integer prodPicNo = null;
			try {
				prodPicNo = Integer.valueOf(str);				
			} catch (Exception e) {
				errorMsgs.add("商品圖片編號格式不正確");
			}
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/select_page.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ShopProductPicService shopProductPicSvc = new ShopProductPicService();
			ShopProductPicVO shopProductPicVO = shopProductPicSvc.getOneProdPicNo(prodPicNo);
			if(shopProductPicVO == null) {
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
			req.setAttribute("shopProductPicVO", shopProductPicVO);
			String url = "/shop/product/listOneProdPic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneProdPic.jsp
			successView.forward(req, res);
	
			
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllProdPic.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數****************************************/
			Integer prodPicNo = Integer.valueOf(req.getParameter("prodPicNo"));
			
			/***************************2.開始查詢資料****************************************/
			ShopProductPicService shopProductPicSvc = new ShopProductPicService();
			ShopProductPicVO shopProductPicVO = shopProductPicSvc.getOneProdPicNo(prodPicNo);
System.out.println("--------------------------");				
System.out.println(shopProductPicVO==null);				
System.out.println("--------------------------");				
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("shopProductPicVO", shopProductPicVO); // 資料庫取出的ShopProductPicVO物件,存入req
			String url = "/shop/product/update_ProdPic_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_ProdPic_input.jsp
			successView.forward(req, res);
		
		}
		
		if("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
			//商品圖片編號 (不可編輯)
			Integer prodPicNo = Integer.valueOf(req.getParameter("prodPicNo").trim());
			
			//商品編號 (?檢查邏輯需確認)
			Integer prodNo = null;
			try {
				prodNo = Integer.valueOf(req.getParameter("prodNo").trim());
			} catch (NumberFormatException e) {
				prodNo = 0;
				errorMsgs.add("圖片編號請填整數");
			}

			
			//照片
			InputStream in = req.getPart("prodPic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
			byte[] prodPic = null;
			if(in.available()!=0) {
				prodPic = new byte[in.available()];
				in.read(prodPic);
				in.close();
			} else {
				ShopProductPicService shopProductPicSvc = new ShopProductPicService();
				prodPic = shopProductPicSvc.getOneProdPicNo(prodPicNo).getProdPic();
			}
			
			ShopProductPicVO shopProductPicVO = new ShopProductPicVO();
			shopProductPicVO.setProdPicNo(prodPicNo);
			shopProductPicVO.setProdNo(prodNo);
			shopProductPicVO.setProdPic(prodPic);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shopProductPicVO", shopProductPicVO); // 含有輸入格式錯誤的shopProductPicVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/update_ProdPic_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷	
			}
			/***************************2.開始修改資料*****************************************/
			ShopProductPicService shopProductPicSvc = new ShopProductPicService();
			shopProductPicVO = shopProductPicSvc.updateProductPic(prodPicNo, prodNo, prodPic);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("shopProductPicVO", shopProductPicVO); // 資料庫update成功後,正確的的shopProductPicVO物件,存入req
			String url = "/shop/product/listOneProdPic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneProdPic.jsp
			successView.forward(req, res);
			
		}
		
		
        if ("insert".equals(action)) { // 來自addProdPic.jsp的請求
        
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
        
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
			//商品圖片編號 (不可編輯)
			Integer prodPicNo = Integer.valueOf(req.getParameter("prodPicNo").trim());
			
			//商品編號 (?檢查邏輯需確認)
			Integer prodNo = null;
			try {
				prodNo = Integer.valueOf(req.getParameter("prodNo").trim());
			} catch (NumberFormatException e) {
				prodNo = 0;
				errorMsgs.add("圖片編號請填整數");
			}

			
			//照片
			InputStream in = req.getPart("prodPic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
			byte[] prodPic = null;
			if(in.available()!=0) {
				prodPic = new byte[in.available()];
				in.read(prodPic);
				in.close();
			} else {
				ShopProductPicService shopProductPicSvc = new ShopProductPicService();
				prodPic = shopProductPicSvc.getOneProdPicNo(prodPicNo).getProdPic();
			}
			
			ShopProductPicVO shopProductPicVO = new ShopProductPicVO();
			shopProductPicVO.setProdPicNo(prodPicNo);
			shopProductPicVO.setProdNo(prodNo);
			shopProductPicVO.setProdPic(prodPic);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shopProductPicVO", shopProductPicVO); // 含有輸入格式錯誤的shopProductPicVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/shop/product/addProdPic.jsp");
				failureView.forward(req, res);
				return; //程式中斷	
			}
        
			/***************************2.開始新增資料***************************************/
			ShopProductPicService shopProductPicSvc = new ShopProductPicService();
			shopProductPicVO = shopProductPicSvc.addProductPic(prodNo, prodPic);
				
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/shop/product/listAllProdPic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
        }
        
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			/***************************1.接收請求參數***************************************/
			Integer prodPicNo = Integer.valueOf(req.getParameter("prodPicNo"));
			/***************************2.開始刪除資料***************************************/
			ShopProductPicService shopProductPicSvc = new ShopProductPicService();
			shopProductPicSvc.deleteProductPic(prodPicNo);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/shop/product/listAllProdPic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	
	}
		
}
