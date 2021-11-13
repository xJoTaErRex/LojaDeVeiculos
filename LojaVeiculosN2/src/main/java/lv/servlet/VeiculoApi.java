package lv.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lv.dao.CompraDAO;
import lv.dao.VeiculoDAO;
import lv.model.Compra;
import lv.model.Veiculo;



/**
 * Servlet implementation class VeiculoApi
 */
@WebServlet("/VeiculoApi")
public class VeiculoApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoApi() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Veiculo v = new Veiculo(
				request.getParameter("modelo"),
				request.getParameter("marca"),
				request.getParameter("motor"),
				request.getParameter("cor"),
				request.getParameter("precoVenda"),
				request.getParameter("ano"),
				request.getParameter("km"),
				request.getParameter("opcionais"),
				request.getParameter("observacoes"),
				request.getParameter("dataEntrada"),
				request.getParameter("unidadeEstoque")
				);
		
		VeiculoDAO dao;
		try {
			dao = new VeiculoDAO();
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
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Veiculo v = new Veiculo();
		v.setIdVeiculo(request.getParameter("idVeiculo"));
		
		VeiculoDAO dao;
		try {
			dao = new VeiculoDAO();
			dao.delete(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Deletado");
	}

}
