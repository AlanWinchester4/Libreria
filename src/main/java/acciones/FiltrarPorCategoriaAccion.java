package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import servicios.ServicioCategoria;
import servicios.ServicioLibros;

public class FiltrarPorCategoriaAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
			int C = Integer.parseInt(request.getParameter("categoria"));
				
			ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request);
			ServicioCategoria servicioCat = (ServicioCategoria) getBean("servicioCategoria", request);
		
			List <Libro> listaDeLibros = servicio.buscarPorCategoria(C);
			List <Categoria> listaDeCategorias = servicioCat.buscarTodos();
			//System.out.println(listaDeLibros.get(C));
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);		
			
			return "MostrarLibros.jsp";	
	}
}
