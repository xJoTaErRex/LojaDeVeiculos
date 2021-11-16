package lv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import lv.dao.CompraDAO;
import lv.model.Compra;

/**
 * Servlet implementation class CompraApi
 */
@WebServlet("/CompraApi")
public class CompraApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setStatus(418);

		String compraId = request.getParameter("idCompra");
		
	    if(compraId != null) {
	    	int id = Integer.parseInt(compraId);
	    	
	    	CompraDAO compraDao;
			try {
				compraDao = new CompraDAO();
				
				Compra compra = compraDao.getCompraById(id);
		     	Gson gson = new Gson();
		    	response.getWriter().append(gson.toJson(compra));
		    	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    } else {
	    	
	    	CompraDAO compraDao;
			try {
				compraDao = new CompraDAO();
				
				List<Compra> compras = compraDao.getAllCompras();
		        
		    	Gson gson = new Gson();

		    	response.getWriter().append(gson.toJson(compras));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Compra c = new Compra(
				request.getParameter("valor"),
				request.getParameter("dataCompra"),
				request.getParameter("idVeiculo")
				);
		
		CompraDAO dao;
		try {
			dao = new CompraDAO();
			dao.insert(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("inserido\n" + c.toString());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Compra c = new Compra(
				request.getParameter("idCompra"),
				request.getParameter("valor"),
				request.getParameter("dataCompra"),
				request.getParameter("idVeiculo")
				);
		
		CompraDAO dao;
		try {
			dao = new CompraDAO();
			dao.update(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Atualizado\n" + c.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Compra c = new Compra();
		c.setIdCompra(request.getParameter("idCompra"));
		
		CompraDAO dao;
		try {
			dao = new CompraDAO();
			dao.delete(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Deletado");
	}

}
