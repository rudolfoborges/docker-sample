package rudolfoborges.docker.samples.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Controller
public class HomeController {


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String get(Model model, HttpServletResponse response) throws UnknownHostException {

		final InetAddress localHost = InetAddress.getLocalHost();

		model.addAttribute("hostname", localHost.getHostAddress());

		return "index";
	}

}
