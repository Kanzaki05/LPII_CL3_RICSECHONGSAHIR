package com.bd.producto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.producto.modelo.ClassProducto;
import com.bd.produtos.servicios.IProductoServicio;


@Controller
@RequestMapping("/Vistas")
public class ProductoController {
	
	@Autowired
	private IProductoServicio iproductoservicio;
	
	@GetMapping("/ListadoProductos")
	public String ListadoProductos(Model modelo) {
		System.out.println("Ingresando al método ListadoProductos");
		List<ClassProducto> listar=iproductoservicio.ListadoProducto();
		
		for (ClassProducto lis:listar) {
			System.out.println("codigo producto "+lis.getIdproductocl3()+" nombre "+lis.getNombrecl3());
		}
		
		
		modelo.addAttribute("ListadoProductos",listar);
		
		return "Vistas/Productos/ListadoProductos";
	}
	
	
	@GetMapping("/Rproducto")
	public String RegistrarProducto(Model modelo) {
		
		ClassProducto producto=new ClassProducto();
		
		modelo.addAttribute("regproducto", producto);
		
		return "Vistas/Productos/FrmRegProducto";
	}
	
	@PostMapping ("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute ClassProducto clpro) {
		
		iproductoservicio.RegistrarProducto(clpro);
		
		return "redirect:/vistas/ListadoProductos";
	}
	
	
	@GetMapping("/Editar/{id}")
	public String Editar(@PathVariable("id") Integer id,Model modelo) {
		
		ClassProducto buscarproducto=iproductoservicio.BuscarProductoCodigo(id);
		
		modelo.addAttribute("regproducto",buscarproducto);
	
		return "Vistas/Producto/FrmRegProducto";
	}
	
	@GetMapping("/Eliminar/{id}")
	public String Eliminar(@PathVariable("id") Integer idpro,Model modelo) {
		
		iproductoservicio.EliminarProducto(idpro);
		List<ClassProducto> listado=iproductoservicio.ListadoProducto();
		
		modelo.addAttribute("listadoproductos", listado);
		
		return "redirect:/vistas/ListadoProductos";
	}
}
