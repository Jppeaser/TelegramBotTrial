package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.crucedebanderas.methods.SendMessage;

@Controller
public class IndexController {
	
	@GetMapping("/test")
	private String indexController() {
		SendMessage sendMessage = new SendMessage();
		return sendMessage.test();
		
	}

}
