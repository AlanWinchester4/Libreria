package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import servicios.ServicioLibros;

public class MostrarEditarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		ServicioLibros serviciosLibros = (ServicioLibros) getBean("servicioLibros", request);
		Libro libro = serviciosLibros.buscarporClave(id);
		request.setAttribute("getNum_lib", libro.getNum_lib());
		request.setAttribute("getisbn_lib", libro.getisbn_lib());
		request.setAttribute("gettit_lib", libro.gettit_lib());
		request.setAttribute("getcat_lib", libro.getcat_lib());
		request.setAttribute("getpre_lib", libro.getpre_lib());
		return "FormularioEditarLibro.jsp";
	}

}
