package com.bd.produtos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bd.producto.modelo.ClassProducto;

@Service
public interface IProductoServicio {

	public List<ClassProducto> ListadoProducto();
	public void RegistrarProducto(ClassProducto clpro);
	public ClassProducto BuscarProductoCodigo(Integer id);
	public void EliminarProducto(Integer id);
	
}
