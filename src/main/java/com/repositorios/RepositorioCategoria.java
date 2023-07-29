package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import beans.Categoria;
public interface RepositorioCategoria extends JpaRepository<Categoria,Integer>
{

}
