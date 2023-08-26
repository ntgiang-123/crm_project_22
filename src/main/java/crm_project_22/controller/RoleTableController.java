package crm_project_22.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_22.service.RoleTableService;

@WebServlet(name="roleTableController", urlPatterns = "/role-table")
public class RoleTableController extends HttpServlet{

	RoleTableService roletableservice = new  RoleTableService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("role-table.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ten = req.getParameter("tenQuyen");
		String mota = req.getParameter("moTa");
		
		boolean isSuccess = roletableservice.checkRoleTable(ten, mota);
		
//		if(isSuccess) {
//			System.out.println("Thêm quyền thành công");
//		}else {
//			System.out.println("Thêm quyền thất bại công");
//		}
		
		req.setAttribute("isSuccess",isSuccess);
		req.getRequestDispatcher("role-table.jsp").forward(req, resp);
	}
}
