package site.radekszostak.cvrepository.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import site.radekszostak.cvrepository.entity.Cv;
import site.radekszostak.cvrepository.entity.User;
import site.radekszostak.cvrepository.service.CvService;
import site.radekszostak.cvrepository.service.UserService;

@Controller
public class DemoController {
	
	@Autowired
	UserService userService;

	@Autowired
	CvService cvService;
	
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

	@GetMapping("/myCv")
	public String editCv(Model theModel, Principal thePrincipal) {
		System.out.println("===> username: " + thePrincipal.getName());
		User theUser = userService.findByUserName(thePrincipal.getName());
		System.out.println("===> User: " + theUser);
		Cv theCv = theUser.getCv();
		System.out.println("===> Cv: " + theCv);
		theModel.addAttribute("cv", theCv);
		return "cv-form";
	}
	
	@PostMapping("/saveCv")
	public String saveCv(@ModelAttribute("cv") Cv theCv, Model theModel) {
		cvService.save(theCv);
		return "home";
	}

	
}










