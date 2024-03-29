package site.radekszostak.cvrepository.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import site.radekszostak.cvrepository.service.PhotoService;


@Controller
@Validated
public class ImageController {

	@Autowired
	private PhotoService photoService;

	@PostMapping("/uploadPhoto")
	public String uploadPhoto(@RequestParam("cvId") String cvId, @RequestParam("photo") MultipartFile file,
			HttpServletRequest request) throws IOException {
		//checking if not file jpg/jpeg
		if (!(file.getContentType().toLowerCase().equals("image/jpg")
				|| file.getContentType().toLowerCase().equals("image/jpeg"))) {
			return "redirect:/editMyCv?imageTypeError";
		} else {
			//file extension check OK - save the file
			try {
				photoService.store(file.getBytes(), cvId.concat(".jpg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/editMyCv?imageSuccess";
		}
	}
	
	//if user provide path /img/user/{cvId}.jpg server will get file from directory specified
	//in application.properties and send it as response
	@GetMapping(value = "/img/user/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] serveFile(@PathVariable String filename) {

		byte[] file = photoService.load(filename);
		return file;
	}
}
