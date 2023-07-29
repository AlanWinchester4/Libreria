package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.repositorios.RepositorioCategoria;

import beans.Categoria;
import dao.CategoriaDAO;
import dbhHelpers.JPAHelper;
@Service
public class ServicioCategoriaImpl implements ServicioCategoria
{
	private CategoriaDAO categoriaDAO = null;
	
	@Autowired
	private RepositorioCategoria repositorio;
	
	public ServicioCategoriaImpl()
	{
		
	}
	@Override
	@Transactional(readOnly=true)
	public List <String> buscarLasCategorias()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<String> consulta = manager.createQuery("SELECT DISTINCT categorias.nom_cat FROM Categoria categorias",String.class);
		List<String> listaDecat_libs = consulta.getResultList();
		manager.close();
		return listaDecat_libs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertar(Categoria categoria) 
	{
		
	}
	@Override
	@Transactional(readOnly=true)
	public List<Categoria> buscarTodos() 
	{
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public void borrar(Categoria categoria) 
	{

	}

	@Override
	@Transactional
	public void guardarCambios(Categoria categoria) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public CategoriaDAO getCategoriaDAO() 
	{
		return categoriaDAO;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) 
	{
		this.categoriaDAO = categoriaDAO;
	}

	
}