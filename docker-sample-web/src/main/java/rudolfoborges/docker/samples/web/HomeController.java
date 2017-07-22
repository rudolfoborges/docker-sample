package rudolfoborges.docker.samples.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Controller
public class HomeController {


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String get(Model model, HttpServletRequest request){
		model.addAttribute("hostname", request.getServerName());

		return "index";
	}

}
