package com.dam2.usuarios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;


@Controller //Esto indica que es una clase controller
//@RequestMapping(path="/ejer3")//Esto indica que la URL empieza con /ejer3
public class Controlador {

	//Indicamos que cargamos el bean llamado UsuarioRepositorio
	//que es auto-generated por Spring y usaremos para manejar los datos
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Autowired
	private UsuarioServicio servicio;
	


	@GetMapping(path="/pedidosarticulos")
	public String Busquedapedido(UsuarioForm pedidoForm,Model modelo) {
		modelo.addAttribute("listaUsuario",usuarioRepositorio.findAll());
		return "/pedidosarticulos";
	}


	@PostMapping(path = "/pedidosarticulos")
	public String Busqueda(@Valid UsuarioForm pedidoForm, BindingResult bindingResult, Model model) {
		model.addAttribute("listaUsuario", pedidoRepositorio.findByPelicula(pedidoForm.getName()));
		return "/listadobusqueda";

	}

	@GetMapping(path="/pedidoscliente")
	public String BusquedaPedidoCliente(PedidoForm usuarioForm,Model modelo) {
		Iterable<Usuario> itUsuario = usuarioRepositorio.findAll();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		itUsuario.forEach(listaUsuarios::add);
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		return "/pedidoscliente";
	}

	@PostMapping(path = "/pedidoscliente")
	public String BusquedapedidoCliente1(@Valid PedidoForm pedidoForm, BindingResult bindingResult, Model model) {
		try {
			List<Pedido> pedNuevo = pedidoRepositorio.findByusuario(pedidoForm.getUsuario());
			model.addAttribute("listaPedidos", pedNuevo);
			System.out.println(pedNuevo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/listadobusquedacliente";
	}


	@GetMapping(path="/altapedido")
	public String showFormAlta(PedidoForm pedidoForm,Model modelo) {
		Iterable<Usuario> itusuario=usuarioRepositorio.findAll();
		List<Usuario> listausuarios = new ArrayList<Usuario>();
		itusuario.forEach(listausuarios::add);
		modelo.addAttribute("listaUsuarios",listausuarios);
		return "/altapedido";
	}



	@PostMapping(path = "/altapedido")
	public String checkPedidoInfo(@Valid PedidoForm pedidoForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "/altapedido";

		}
		Pedido pedido1= new Pedido(null, pedidoForm.getPelicula(),pedidoForm.getAnyo(),
		pedidoForm.getDirector(),pedidoForm.getDuracion(),pedidoForm.getCategoria(),pedidoForm.getUsuario());
		pedidoRepositorio.save(pedido1);
		model.addAttribute("mensaje", "Pedido "+pedido1.getPelicula()+ " recepcionado correctamente");
		return "principio";

	}

	@GetMapping(path="/listadopedido")

	public String listarpedidos(Model modelo) {

		Iterable<Pedido> itPedido = pedidoRepositorio.findAll();

		System.out.println("it Pedidos: "+itPedido);

		List<Pedido> listaPedidos = new ArrayList<Pedido>();

		itPedido.forEach(listaPedidos::add);

		modelo.addAttribute("listaPedidos",listaPedidos);

		return "/listadopedido";


	}


	//Te lleva a la pagina principal index
	@GetMapping("/index") 
	public String login(Model model) {
		return "index";
	}
	//Te lleva a la pagina principal index
		@GetMapping("/principio") 
		public String iniPg(Model model) {
			return "principio";
		}
		
		
		@GetMapping("/index2") 
		public String login2(Model model) {
			return "index2";
		}


	@GetMapping(path="/listausuarios")
	public String getListaUsuarios (Model modelo) {
		// Devolvemos la respuesta con los usuario
		//Pero primero convertimos del iterator a lis
		Iterable<Usuario> itUsuario = usuarioRepositorio.findAll();
		System.out.println("itUsuario:" + itUsuario);
		//Convertimos
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		itUsuario.forEach(listaUsuarios::add);
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		return "/listausuarios";
	}

	//Cuando venimos desde Get para dar alta el usuario
	@GetMapping(path="/altausuario")
	public String showForm(UsuarioForm personForm) {
		return "/altausuario";
	}

	//venimos desde alta y rellenar los datos, validamos los datos
	@PostMapping(path="/altausuario")
	public String checkPersonInfo(@Valid UsuarioForm usuForm, BindingResult bindingResult, Model modelo) {

		if (bindingResult.hasErrors()) {
			return "/altausuario";
		}
		Usuario usuNuevo = new Usuario(usuForm.getName(), usuForm.getEmail(), usuForm.getApellido(),usuForm.getDni());
		usuarioRepositorio.save(usuNuevo);
		modelo.addAttribute("mensaje", "Usuario " + usuForm.getName() + " dado de alta correctamente");
		return "principio";

	}
	
	
	


	@GetMapping("/caracteristicas")
	public String index() {
		return "caracteristicas";
	}

	@GetMapping("/opcadmin")
	public String index2() {
		return "opcadmin";
	}
	
	@GetMapping("/informacion")
	public String index3() {
		return "informacion";
	}
	
	@GetMapping("/usu")
	public String index4() {
		return "usu";
	}
	
	
	@GetMapping("/principio2")
	public String index5() {
		return "principio2";
	}
	
	@GetMapping("/multifilms")
	public String multifilms() {
		return "multifilms";
	}
	
	@GetMapping("/infoshop")
	public String infoshop() {
		return "infoshop";
	}
	
	@GetMapping("/caracteristicas2")
	public String caracteristicas2() {
		return "caracteristicas2";
	}
	
	@GetMapping("/acerca")
	public String acerca() {
		return "acerca";
	}
	
	
	
	
	// añadir 
		@GetMapping("/login")
		public String iniciarSesion() {
			return "login";
		}
		
		@GetMapping("/")
		public String verPaginaDeInicio(Model modelo) {
			modelo.addAttribute("usuarios", servicio.listarUsuarios());
			return "principio";
		}
	
		
	
	
	
	@Controller
	@RequestMapping("/registro")
	public class RegistroUsuarioControlador {

		private UsuarioServicio usuarioServicio;

		public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
			super();
			this.usuarioServicio = usuarioServicio;
		}
		
		@ModelAttribute("usuario")
		public UsuRegDTO retornarNuevoUsuarioRegistroDTO() {
			return new UsuRegDTO();
		}

		@GetMapping
		public String mostrarFormularioDeRegistro() {
			return "registro";
		}
		
		@PostMapping
		public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuRegDTO registroDTO) {
			usuarioServicio.guardar(registroDTO);
			return "redirect:/registro?exito";
		}
	}
	
	
	
	
}









