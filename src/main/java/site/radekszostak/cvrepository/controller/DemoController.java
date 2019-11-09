package site.radekszostak.cvrepository.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import site.radekszostak.cvrepository.entity.Cv;
import site.radekszostak.cvrepository.entity.User;
import site.radekszostak.cvrepository.service.CvService;
import site.radekszostak.cvrepository.service.UserService;


@Controller
public class DemoController {

	@Autowired
	private UserService userService;

	@Autowired
	private CvService cvService;

	

	@GetMapping("/")
	public String showHome(Model theModel) {
		List<Cv> theCvs = cvService.findAllPublic();
		System.out.println("===> theCvs: " + theCvs);
		theModel.addAttribute("cvs", theCvs);
		return "browse";
	}

	@GetMapping("/viewMyCv")
	public String viewMyCv(Model theModel, Principal thePrincipal) {
		System.out.println("===> username: " + thePrincipal.getName());
		User theUser = userService.findByUserName(thePrincipal.getName());

		return "redirect:/showCv?id=" + theUser.getCv().getId();
	}

	@GetMapping("/editMyCv")
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

		System.out.println("===> Cv is publish: " + theCv.isPublish());
		cvService.save(theCv);
		return "cv-form";
	}



	

	@GetMapping("/showCv")
	public String showCv(@RequestParam("id") int cvId, Model theModel, Principal thePrincipal) {
		theModel.addAttribute("cv", cvService.findById(cvId));
		System.out.println("===> thePrincipal: " + thePrincipal);
		if (thePrincipal != null) {
			User theUser = userService.findByUserName(thePrincipal.getName());
			theModel.addAttribute("loggedUser", theUser);
		}
		return "cv-view";
	}

}
