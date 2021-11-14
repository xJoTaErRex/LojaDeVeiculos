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
import lv.dao.VendaDAO;
import lv.model.Compra;
import lv.model.Venda;

/**
 * Servlet implementation class VendaAPI
 */
@WebServlet("/VendaApi")
public class VendaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendaApi() {
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
		String vendaId = request.getParameter("idVenda");

		if (vendaId != null) {
			int id = Integer.parseInt(vendaId);

			VendaDAO vendaDao;
			try {
				vendaDao = new VendaDAO();

				Venda venda = vendaDao.getVendaById(id);
				Gson gson = new Gson();
				response.getWriter().append(gson.toJson(venda));

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			VendaDAO vendaDao;
			try {
				vendaDao = new VendaDAO();

				List<Venda> vendas = vendaDao.getAllVendas();

				Gson gson = new Gson();

				response.getWriter().append(gson.toJson(vendas));
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
		
		Venda v = new Venda(
				request.getParameter("valor"),
				request.getParameter("idVeiculo"),
				request.getParameter("nomeVendedor"),
				request.getParameter("dataCompra")
				);
		
		VendaDAO dao;
		try {
			dao = new VendaDAO();
			dao.insert(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("inserido\n" + v.toString());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Venda v = new Venda(
				request.getParameter("idVenda"),
				request.getParameter("valor"),
				request.getParameter("idVeiculo"),
				request.getParameter("nomeVendedor"),
				request.getParameter("dataCompra")
				);
		
		VendaDAO dao;
		try {
			dao = new VendaDAO();
			dao.update(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Alterado\n" + v.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Venda v = new Venda();
		v.setIdVenda(request.getParameter("idVenda"));
		
		VendaDAO dao;
		try {
			dao = new VendaDAO();
			dao.delete(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Deletado");
	}

}
