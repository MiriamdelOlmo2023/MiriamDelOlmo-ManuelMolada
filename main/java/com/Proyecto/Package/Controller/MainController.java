package com.Proyecto.Package.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Proyecto.Package.DTO.ApuestasGalgosDTO;
import com.Proyecto.Package.DTO.ApuestasRuletaDTO;
import com.Proyecto.Package.DTO.UsuarioDTO;
import com.Proyecto.Package.Service.IServiceApuestasGalgos;
import com.Proyecto.Package.Service.IServiceApuestasRuleta;
import com.Proyecto.Package.Service.IServiceUsuario;

@Controller
public class MainController {

	boolean isLogged = false;
	String loggedUser;
	String loggedPwd;
	
	@Autowired
	private IServiceUsuario servicio;
	
	@Autowired
	private IServiceApuestasRuleta servicioRuleta;
	
	@Autowired
	private IServiceApuestasGalgos servicioGalgos;
	
   @Autowired
    private CorreoController correoController;

	
	// LOGIN
    @GetMapping(value = {"", "/", "/login", "/index"})
    public String index(Model model) {
    	String ret = "error";
    	try {
	    	if(isLogged) {
	    		model.addAttribute("username", loggedUser);
	    		model.addAttribute("fichas", servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
	    		ret = "menu";
	    	} else {
	    		 model.addAttribute("titulo", "LOGIN");
		        ret = "index";
	    	}
		}catch (Exception e){
			
		}
	    	
    	return ret;
    }
	
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
    	String salida = "error";
    	if(isLogged) {
    		model.addAttribute("username", loggedUser);
    		model.addAttribute("fichas", servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
    		salida = "menu";
    	} else {
    		try {
		    	if(servicio.login(username, password)) {
		    		isLogged = true;
		    		loggedUser = username;
		    		loggedPwd = password;
		    		salida = "menu";
		    		model.addAttribute("username", username);
		    		model.addAttribute("fichas", servicio.obtenerDTO(username, password).getFichas());
		    		
		    	} else {
		    		salida = "index";
		    		model.addAttribute("login", "El usuario o contraseña son inválidos");
		    	}
			}catch (Exception e){
				
			}
    	}
        return salida;
    }
    
    @GetMapping("cerrarSesion")
    public String cerrarSesion(Model model) {
    	isLogged = false;
    	loggedUser = null;
    	loggedPwd = null;
    	return "index";
    }

    @GetMapping("/registro")
    public String formularioRegistro(Model model) {
    	String salida = "error";
    	if(isLogged) {
    		model.addAttribute("username", loggedUser);
    		model.addAttribute("fichas", servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
    		salida = "menu";
    	} else {
    		model.addAttribute("login", "");
    		salida = "registro";
    	}
        return salida;
    }
    
    @PostMapping("/registrar")
    public String registrar(Model model, final UsuarioDTO usuario) {

    	String salida = "error";
    	if(isLogged) {
    		model.addAttribute("username", loggedUser);
    		model.addAttribute("fichas", servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
    		salida = "menu";
    	} else {
	    	try {
		    	if(servicio.register(usuario.getUsername(), usuario.getPassword(), usuario.getEmail())) {
	
	                correoController.enviarCorreo(usuario.getUsername(), usuario.getEmail());
		    		salida = "index";
		    		model.addAttribute("login", "Usuario creado correctamente");
		    		model.addAttribute("username", usuario.getUsername());
		    		model.addAttribute("password", usuario.getPassword());
		    	} else {
		    		salida = "registro";
		    		model.addAttribute("login", "Uno o varios campos no son válidos");
		    	}
	    	}catch (Exception e){
	    		e.printStackTrace();
	    	}
    	}
		return salida;
	}
    
    @GetMapping("/cambiarPwd")
    public String cambiarPwd(Model model) {
    	return "changePwd";
    }
    
    @PostMapping("/acceptChangePwd")
    public String procesarFormulario(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String passwordNueva,
                                     Model model) {
    	String ret = "error";

        if (loggedUser.equals(username) && loggedPwd.equals(password)) {
        	try {
            	UsuarioDTO user = servicio.obtenerDTO(username, password);
                user.setPassword(passwordNueva);
                servicio.guardar(user);
                
                loggedPwd = passwordNueva;
        		model.addAttribute("username", loggedUser);
        		model.addAttribute("password", loggedPwd);
                model.addAttribute("login", "Cambio de contraseña exitoso");
                ret = "index";
        	}catch (Exception e) {
        		e.printStackTrace();
			}
        	
        } else {
            model.addAttribute("login", "Usuario o contraseña incorrectos");
            ret = "changePwd";
        }

        return ret;
    }
    
    @GetMapping("/ruletaJuego")
    public String mostrarRuleta(Model model) {
    	model.addAttribute("fichas", servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
        return "ruleta";
    }
    
    @GetMapping("/galgosJuego")
    public String mostrarGalgos(Model model) {
    	System.out.println(servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
    	model.addAttribute("fichas", servicio.obtenerDTO(loggedUser, loggedPwd).getFichas());
        return "galgos";
    }
    
    @PostMapping("/llamadaFichas")
    @ResponseBody
    public String manejarLlamadaAjax(@RequestBody Map<String, String> fichasMap, Model model) {
        String ret = "";
        try {
        	UsuarioDTO user = servicio.obtenerDTO(loggedUser, loggedPwd);
            String fichasString = fichasMap.get("fichas");
            user.setFichas(user.getFichas()+(Integer.parseInt(fichasString)));

            servicio.guardar(user);
            ret = "menu";
        } catch (Exception e) {

            ret = "error";
        }
        return ret;
    }    
    
    
    @PostMapping("/llamadaFichasRuleta")
    @ResponseBody
    public String manejarLlamadaAjaxRuleta(@RequestBody Map<String, String> fichasMap, Model model) {
        String ret = "";
        try {
        	UsuarioDTO user = servicio.obtenerDTO(loggedUser, loggedPwd);
            String fichasString = fichasMap.get("fichas");
            user.setFichas(user.getFichas()+(Integer.parseInt(fichasString)));

            servicio.guardar(user);
            ret = "ruleta";
        } catch (Exception e) {

            ret = "error";
        }
        return ret;
    }
    
    @PostMapping("/llamadaFichasGalgos")
    @ResponseBody
    public String manejarLlamadaAjaxGalgos(@RequestBody Map<String, String> fichasMap, Model model) {
        String ret = "";
        try {
        	UsuarioDTO user = servicio.obtenerDTO(loggedUser, loggedPwd);
            String fichasString = fichasMap.get("fichas");
            user.setFichas((Integer.parseInt(fichasString)));

            servicio.guardar(user);
            ret = "galgos";
        } catch (Exception e) {

            ret = "error";
        }
        return ret;
    } 
    
    
    @PostMapping("/llamadaApuestaRuleta")
    @ResponseBody
    public String manejarLlamadaAjaxApuestaRuleta(@RequestBody Map<String, String> datosJson) {
        String ret = "";
        try {
        	ApuestasRuletaDTO nueva = new ApuestasRuletaDTO();
        	nueva.setApostado(Integer.parseInt(datosJson.get("apostado")));
        	nueva.setFecha(datosJson.get("fecha"));
        	nueva.setUsuario(servicio.obtenerDTO(loggedUser, loggedPwd));
        	servicioRuleta.crear(nueva);
        	
            ret = "ruleta";
        } catch (Exception e) {
            ret = "error";
        }
        return ret;
    }
    
    @PostMapping("/llamadaApuestaGalgos")
    @ResponseBody
    public String manejarLlamadaAjaxApuestaGalgos(@RequestBody Map<String, String> datosJson) {
        String ret = "";
        try {
        	ApuestasGalgosDTO nueva = new ApuestasGalgosDTO();
        	nueva.setApostado(Integer.parseInt(datosJson.get("apostado")));
        	nueva.setFecha(datosJson.get("fecha"));
        	nueva.setUsuario(servicio.obtenerDTO(loggedUser, loggedPwd));
        	nueva.setCircuito(datosJson.get("circuito"));
        	nueva.setGalgo(datosJson.get("galgo"));
        	
        	servicioGalgos.crear(nueva);
        	
            ret = "ruleta";
        } catch (Exception e) {
            ret = "error";
        }
        return ret;
    }
    
}