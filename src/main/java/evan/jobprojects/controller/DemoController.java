package evan.jobprojects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //This annotation is specialization type of the @component annotationa nd indicates that the clase is a "web controller"
public class DemoController {
     //With this annotation and method, when we open the http url with the /hello on the end the http get request
     // will be mapped to the method which will invoke the method.
    // http://localhost:8080/todo-list/hello
    @ResponseBody //this annotation indicates that a method return value should be bound to the web response body. in this case "hello"
    //The controller writes directly to the response body.. This is added here before we created any views.
    @GetMapping("/hello")
     public String hello() {
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    // prefix + name + suffix
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
        //the returned string represents the returned view name (our view is called welcome.jsp). As the pre/suffix were
        //already specified in the resolver, we don't have to specify in this method.
    }
}
