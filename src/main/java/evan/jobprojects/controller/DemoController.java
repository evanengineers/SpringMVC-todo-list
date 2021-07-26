package evan.jobprojects.controller;

import evan.jobprojects.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
//This annotation is specialization type of the @component annotationa and indicates that the class is a "web controller"
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
    //this annotation above indicates that a method return value should be bound to the web response body. in this case "hello". this controller is returning the text instead of the view.
    //The controller writes directly to the response body.. This is added here before we created any views.
    @GetMapping("/hello")
    public String hello() {
        return "hello";//<-- the hello here is actually the view name.
    }

    // http://localhost:8080/todo-list/welcome
    // http://localhost:8080/todo-list/welcome?user=Evan
    //Here we are going to use the /welcome view we created in the welcome.jsp. NO @Responsebody needed because of that.
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        //model will return user name. Name of the attribute must be same here as in jsp page
        model.addAttribute("age", age);
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
