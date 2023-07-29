package acciones;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import servicios.ServicioCategoria;
import servicios.ServicioLibros;

public class MostrarLibrosAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioLibros serviciosLibros = (ServicioLibros) getBean("servicioLibros", request);
		ServicioCategoria servicioCategoria = (ServicioCategoria) getBean("servicioCategoria", request);
		
		List <Libro> listaDeLibros = serviciosLibros.buscarTodos();
		List <Categoria> listaDeCategorias = servicioCategoria.buscarTodos();
		/*ArrayList <Categoria> listaDeCategorias2=null;
		for(int i=0; i<listaDeLibros.size(); i++)
		{
			
			for(int n=0; n<listaDeCategorias.size(); n++)
			{
				if(listaDeLibros.get(i).getCategoria().getNom_cat().equals(listaDeCategorias.get(n).getNom_cat()))
				{
					int num=0;
					listaDeCategorias2.add(listaDeCategorias.get(i));
					i++;
				}
				
			}
			
		}*/
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);	
		return "MostrarLibros.jsp";
	}

}
