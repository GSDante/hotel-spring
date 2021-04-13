package ufrn.imd.hotelRibbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="hotel-clienteAuth")
@RibbonClient(name="hotel-clienteAuth")
public interface ClienteAuthProxy {

	@PostMapping("/ClienteAuth/login")
	public UsuarioBean loginCliente(@RequestBody String message);
	
	@PostMapping("/ClienteAuth/cadastro")
	public UsuarioBean cadastroCliente(@RequestBody String message) ;
}
