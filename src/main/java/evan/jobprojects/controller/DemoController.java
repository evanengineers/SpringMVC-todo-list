package evan.jobprojects.controller;

import evan.jobprojects.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
//This annotation is specialization type of the @component annotationa nd indicates that the clase is a "web controller"
public class DemoController {

    // == fields ==
    private final DemoService demoService;


    // == Constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    // == request methods ==
    //With this annotation and method, when we open the http url with the /hello on the end the http get request
    // will be mapped to the method which will invoke the method.
    // http://localhost:8080/todo-list/hello
    @ResponseBody
    //this annotation indicates that a method return value should be bound to the web response body. in this case "hello"
    //The controller writes directly to the response body.. This is added here before we created any views.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome

    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage("Evan")); //model will return user name. Name of the attribute must be same here as in jsp page
        //remember that "Evan" is the value of the model attribute (user).
        log.info("model = {}", model);
        // prefix + name + suffix
        // /WEB-INF/view/welcome.js
        return "welcome";
        //the returned string represents the returned view name (our view is called welcome.jsp). As the pre/suffix were
        //already specified in the resolver, we don't have to specify in this method.
    }

    // == Model Attributes ==
    //The annotation below is just a implicit way of doing the above.
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {

        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
