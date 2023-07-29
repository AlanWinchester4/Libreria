package com.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beans.Libro;
@Repository
public abstract interface RepositorioLibro extends JpaRepository<Libro,Integer>
{

}
