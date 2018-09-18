package com.business.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.entity.Categorys;
import com.business.entity.Products;
import com.business.entity.Providers;
import com.business.service.CategorysService;
import com.business.service.ProductsService;
import com.business.service.ProviderService;
import com.business.util.Page;
@WebServlet("/admin/products/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	    
		String op = request.getParameter("op");
		System.out.println(op+"------------ProductsServlet");
		if("doShowProducts".equals(op)) {
			doShowProducts( request,  response);
		}else if("doReadyEdit".equals(op)) {
			doReadyEdit( request,  response);
		}else if("doReadyProducts".equals(op)) {
			doReadyProducts( request,  response);
		}else if("doEditProduct".equals(op)) {
			doEditProduct(request,  response);
		}else if("doDeleteProducts".equals(op)) {
			doDeleteProducts(request,  response);
		}else if("doAddProduct".equals(op)) {
			doAddProduct(request,  response);
		}
		
	}
	
	
	
	


	private void doAddProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");  	
		
	    PrintWriter out = response.getWriter();
	    //得到add后的所有数据
		//int productID = Integer.parseInt(request.getParameter("productID"));
		String product_name = request.getParameter("product_name");
		double income_price = Double.parseDouble(request.getParameter("income_price"));
		int providerID = Integer.parseInt(request.getParameter("provider"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double sales_price = Double.parseDouble(request.getParameter("sales_price"));
		int categoeyID = Integer.parseInt(request.getParameter("categoey"));
		String income_time = request.getParameter("income_time");
		
		Products p = new Products(product_name, income_price, new Providers(providerID), 
				quantity, sales_price, new Categorys(categoeyID), income_time);
		ProductsService ps= new ProductsService();
		int i = ps.addProductsByName(p);
		if(i>0){
			out.write("<script>alert('恭喜，产品增加成功！');location.href ='ProductsServlet?op=doShowProducts&currentPage=1&pageSize=3' </script>");
		}else{
			out.write("<script>alert('对不起，产品增加失败！');history.back() ;</script>");
		}	
		
	}






	private void doDeleteProducts(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		int id = Integer.valueOf(request.getParameter("id"));
			ProductsService ps = new ProductsService();
			/* Products p = new Products();
			ps.removeProducts(new Products(p.getProductID())); */
			boolean f = ps.removeProductsById(id);
			
			if(f){
				out.write("<script>alert('恭喜，产品删除成功！');location.href ='ProductsServlet?op=doShowProducts&currentPage=1&pageSize=3' </script>");
			}else{
				out.write("<script>alert('对不起，产品删除失败！');location.href ='ProductsServlet?op=doShowProducts&currentPage=1&pageSize=3' </script>");
			}
		
	}






	private void doEditProduct(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; Charset=UTF-8");  
		
	    PrintWriter out = response.getWriter();
		//得到修改后的所有数据
		int productID = Integer.parseInt(request.getParameter("productID"));
		String product_name = request.getParameter("product_name");
		double income_price = Double.parseDouble(request.getParameter("income_price"));
		int providerID = Integer.parseInt(request.getParameter("provider"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double sales_price = Double.parseDouble(request.getParameter("sales_price"));
		int categoeyID = Integer.parseInt(request.getParameter("categoey"));
		String income_time = request.getParameter("income_time");
		
		Products p = new Products(productID,product_name, income_price, new Providers(providerID), 
				quantity, sales_price, new Categorys(categoeyID), income_time);
		ProductsService ps= new ProductsService();
		int i = ps.modifyProduct(p);
		
		if(i>0){
			out.write("<script>alert('恭喜，产品修改成功！');location.href ='ProductsServlet?op=doShowProducts&currentPage=1&pageSize=3' </script>");
		}else{
			out.write("<script>alert('对不起，产品修改失败！');history.back() ;</script>");
		}
		
	}






	private void doReadyProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//ProductsService ps = new ProductsService();
		//得到所有供应商数据
		ProviderService pvs = new ProviderService();
		List<Providers> pv =  pvs.findAllProviders();
		//得到所有目录数据
		CategorysService cgs = new CategorysService();
		List<Categorys> cg = cgs.findAllCategorys();	
		//传值	
		request.setAttribute("pv", pv);
		request.setAttribute("cg",cg);	
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);	
		
	}






	private void doReadyEdit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		ProductsService ps = new ProductsService();
		//得到需要修改的产品数据
		Products p = ps.findProductById(id);
		//得到所有供应商数据
		ProviderService pvs = new ProviderService();
		List<Providers> pv =  pvs.findAllProviders();
		//得到所有目录数据
		CategorysService cgs = new CategorysService();
		List<Categorys> cg = cgs.findAllCategorys();
		
		//传值
		request.setAttribute("p", p);
		request.setAttribute("pv", pv);
		request.setAttribute("cg",cg);
		
		request.getRequestDispatcher("editProducts.jsp").forward(request, response);
		
		
	}






	private void doShowProducts(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	 		
		ProductsService ps = new ProductsService();				
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			
			Page<Products> propage = ps.findAllProductByPage(new Page<Products>(currentPage,pageSize));
			request.setAttribute("propage", propage);
			request.getRequestDispatcher("showAllProducts.jsp").forward(request, response);
		
	}






	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
