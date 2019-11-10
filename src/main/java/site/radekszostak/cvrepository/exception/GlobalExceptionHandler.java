package site.radekszostak.cvrepository.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class GlobalExceptionHandler {
  public static final String DEFAULT_ERROR_VIEW = "error";
  
  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ModelAndView handleConflict() {
	  ModelAndView mav = new ModelAndView();
	    mav.addObject("text", "Maximum file size excedeed.");
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return mav;
  }
}