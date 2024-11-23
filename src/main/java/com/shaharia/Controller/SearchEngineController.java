package com.shaharia.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchEngineController {

	  @GetMapping("/home")
	   public String search() {
		  System.out.println("Inside home method");
		  return "home";
	  }
	  
	  @GetMapping("/search")
	  public RedirectView searchHandler(@RequestParam("textArea") String searchItem) {
		  System.out.println("The string to be searched is : " + searchItem );
		  
		  String url = "https://www.google.com/search?";
		  String addUrlParameter = String.format("q=%s", searchItem); //for adding parameter
		  
		  String finalUrl = String.join("", url , addUrlParameter);
		  
		  System.out.println("the final url is : " + finalUrl);
		  
		  RedirectView redirectView = new RedirectView();
		  redirectView.setUrl(finalUrl);
		  
		  return redirectView;
	  }
	 
}
