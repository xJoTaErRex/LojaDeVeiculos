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

import lv.dao.UsuarioDAO;
import lv.model.Usuario;

/**
 * Servlet implementation class CrudApi
 */
@WebServlet("/UserApi")
public class UserApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserApi() {
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

		String userId = request.getParameter("idUser");
		
	    if(userId != null) {
	    	int id = Integer.parseInt(userId);
	    	
	    	UsuarioDAO usuarioDao;
			try {
				usuarioDao = new UsuarioDAO();
				
				Usuario usuario = usuarioDao.getUsuarioById(id);
		     	Gson gson = new Gson();
		    	response.getWriter().append(gson.toJson(usuario));
		    	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    } else {
	    	
	    	UsuarioDAO usuarioDao;
			try {
				usuarioDao = new UsuarioDAO();
				
				List<Usuario> usuarios = usuarioDao.getAllUsuario();
		        
		    	Gson gson = new Gson();

		    	response.getWriter().append(gson.toJson(usuarios));
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
		
		Usuario u = new Usuario(
				request.getParameter("name"),
				request.getParameter("login"),
				request.getParameter("cargo"),
				request.getParameter("senha")
				);
		
		UsuarioDAO dao;
		try {
			dao = new UsuarioDAO();
			dao.insert(u);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("inserido\n" + u.toString());
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
		
		Usuario u = new Usuario();
		u.setIdUsuario(request.getParameter("idUsuario"));
		
		UsuarioDAO dao;
		try {
			dao = new UsuarioDAO();
			dao.delete(u);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Deletado");
	}

}
