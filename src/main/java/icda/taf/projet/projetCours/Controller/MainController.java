package icda.taf.projet.projetCours.Controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController  implements ErrorController{//

	private static final String PATH = "/error"; 
	
	@RequestMapping(value="/")
	public String index(){
		return "cours";
	}
	
	@RequestMapping(value=PATH)
	public String error(){
		return "404";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
