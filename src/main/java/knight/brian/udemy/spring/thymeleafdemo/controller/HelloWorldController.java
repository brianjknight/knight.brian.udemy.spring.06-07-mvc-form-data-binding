package knight.brian.udemy.spring.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class HelloWorldController {

    // controller method to show initial form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(Model model) {

        model.addAttribute("theDate", LocalDateTime.now());

        return "helloworld";
    }

    // processing HTML form manipulating data for the Model
    @RequestMapping(path="/processFormVersionTwo", method=RequestMethod.GET)
    public String letsShout(HttpServletRequest request, Model model) {

        // read the request parameter from the form
        String theName =  request.getParameter("studentName");

        // convert the incoming data
        theName = theName.toUpperCase();

        // create a message
        String result = "Yo! " + theName;

        // add data to the model
        model.addAttribute("theDate", LocalDateTime.now());
        model.addAttribute("message", result);

        return "helloworld";
    }

    // processing HTML form binding request parameters
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName, Model model) {

        // convert the incoming data
        theName = theName.toUpperCase();

        // create a message
        String result = "Howdy " + theName;

        // add data to the model
        model.addAttribute("theDate", LocalDateTime.now());
        model.addAttribute("message", result);

        return "helloworld";
    }
}
