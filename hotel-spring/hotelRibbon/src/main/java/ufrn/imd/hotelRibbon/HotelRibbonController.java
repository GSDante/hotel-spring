package ufrn.imd.hotelRibbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelRibbonController {

	@Autowired
	private ClienteAuthProxy proxy;
	
	@PostMapping("/ClienteAuth-feign/login")
	public UsuarioBean loginCliente(@RequestBody String message) {
		UsuarioBean response = proxy.loginCliente(message);
		return new UsuarioBean(response.getId(), response.getLogin(), 
				response.getSenha(),response.getTokenValue(),response.getPort());
	}
	
	@PostMapping("/ClienteAuth/cadastro")
	public UsuarioBean cadastroCliente(@RequestBody String message) {
		UsuarioBean response = proxy.cadastroCliente(message);
		return new UsuarioBean(response.getId(), response.getLogin(), 
				response.getSenha(),response.getTokenValue(),response.getPort());
		
	}
}
