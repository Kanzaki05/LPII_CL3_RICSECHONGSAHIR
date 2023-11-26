package com.bd.producto.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bd.producto.modelo.ClassProducto;

@Repository
public interface IProducto extends CrudRepository<ClassProducto,Integer>{

	
}
