package servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.repositorios.RepositorioLibro;

import beans.Libro;
import dao.LibroDAO;
@Service
public class ServicioLibrosImpl implements ServicioLibros
{

	private LibroDAO libroDAO =null;
	@Autowired
	private RepositorioLibro repositorio;
	
	public ServicioLibrosImpl()
	{
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertar(Libro libro) 
	{
		libroDAO.insertar(libro);;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Libro> buscarTodos() 
	{
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public void borrar(Libro libro) 
	{
		libroDAO.borrar(libro);
	}

	@Override
	@Transactional
	public void guardarCambios(Libro libro) 
	{
		//libroDAO.guardarCambios(libro);
		repositorio.save(libro);
	}

	@Override
	@Transactional(readOnly=true)
	public Libro buscarporClave(Integer id) 
	{
		return this.libroDAO.buscarporClave(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Libro> buscarPorCategoria(int Cat) 
	{
		return libroDAO.buscarPorCategoria(Cat);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Integer> buscarLasCategorias()
	{
		//return categoriaDAO.buscarLasCategorias();
		return null;
	}

	@Override
	@Transactional
	public LibroDAO getLibroDAO() 
	{
		return libroDAO;
	}

	@Override
	@Transactional
	public void setLibroDAO(LibroDAO libroDAO) 
	{
		this.libroDAO = libroDAO;
	}
}
