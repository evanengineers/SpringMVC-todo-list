package evan.jobprojects.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    // == constants ==
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");

        // create the spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // create dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        //now we must register & configure the distcher servlet. we'll use the servlet context param to call the method @servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        registration.setLoadOnStartup(1); //using this to configure the startup loading of the servlet so the container will
        //instantiate and initialize our servlet upon startup
        registration.addMapping("/"); //maps our servlet to the url pattern specified which will override the default tomcat
        //hompage because you don't want to display the tomcat homepage to end users but you want to display your own app.

    }
}
