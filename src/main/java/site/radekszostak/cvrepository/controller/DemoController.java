package site.radekszostak.cvrepository.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import site.radekszostak.cvrepository.entity.Cv;
import site.radekszostak.cvrepository.entity.User;
import site.radekszostak.cvrepository.service.CvService;
import site.radekszostak.cvrepository.service.PhotoService;
import site.radekszostak.cvrepository.service.UserService;

@Controller
public class DemoController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private CvService cvService;
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		List<Cv> theCvs = cvService.findAllPublic();
		System.out.println("===> theCvs: " + theCvs);
		theModel.addAttribute("cvs", theCvs);
		return "home";
	}
	
	@GetMapping("/viewMyCv")
	public String viewMyCv(Model theModel, Principal thePrincipal) {
		System.out.println("===> username: " + thePrincipal.getName());
		User theUser = userService.findByUserName(thePrincipal.getName());
		
		return "redirect:/showCv?id="+theUser.getCv().getId();
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
		return "redirect:/viewMyCv";
	}
	
	@PostMapping("/uploadPhoto")
	public String uploadPhoto(@RequestParam("cvId") String cvId, @RequestParam("photo") MultipartFile file, HttpServletRequest request) {
		System.out.println("===> cvId: " + cvId);
		try {
			photoService.store(file.getBytes(), cvId.concat(".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/editMyCv";
	}
    @GetMapping(value ="/img/user/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] serveFile(@PathVariable String filename) {
    	
        byte [] file = photoService.load(filename);
        return file;
    }
    
    @GetMapping("/showCv")
    public String showCv(@RequestParam("id") int cvId, Model theModel, Principal thePrincipal) {
    	theModel.addAttribute("cv", cvService.findById(cvId));
  	
    	theModel.addAttribute("loggedUser", userService.findByUserName(thePrincipal.getName()));
    	
    	return "cv-view";
    }

	

	
}










