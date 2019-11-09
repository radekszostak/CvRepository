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
public class CvController {

	@Autowired
	private UserService userService;

	@Autowired
	private CvService cvService;

	//Main page - CV repository
	@GetMapping("/")
	public String showHome(Model theModel) {
		List<Cv> theCvs = cvService.findAllPublic();
		theModel.addAttribute("cvs", theCvs);
		return "browse";
	}

	//Searching for id of my CV and redirecting
	@GetMapping("/viewMyCv")
	public String viewMyCv(Model theModel, Principal thePrincipal) {
		User theUser = userService.findByUserName(thePrincipal.getName());
		return "redirect:/showCv?id=" + theUser.getCv().getId();
	}

	//CV edition form
	@GetMapping("/editMyCv")
	public String editCv(Model theModel, Principal thePrincipal) {
		User theUser = userService.findByUserName(thePrincipal.getName());
		Cv theCv = theUser.getCv();
		theModel.addAttribute("cv", theCv);
		return "cv-form";
	}

	//save CV to DB - just delegate to cvService
	@PostMapping("/saveCv")
	public String saveCv(@ModelAttribute("cv") Cv theCv, Model theModel) {
		cvService.save(theCv);
		return "redirect:/editMyCv?cvSaved";
	}

	//getting CV ID parameter from GET request. Then writing proper CV data to response
	@GetMapping("/showCv")
	public String showCv(@RequestParam("id") int cvId, Model theModel, Principal thePrincipal) {
		theModel.addAttribute("cv", cvService.findById(cvId));
		//if user is logged in and he view his own CV, there will be available EDIT button.
		//Below data is necessary for template to decide if show this button.
		if (thePrincipal != null) {
			User theUser = userService.findByUserName(thePrincipal.getName());
			theModel.addAttribute("loggedUser", theUser);
		}
		return "cv-view";
	}

}
