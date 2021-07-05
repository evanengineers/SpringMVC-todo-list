package evan.jobprojects.service;

import org.springframework.stereotype.Service;

@Service  //another stereotype annotation for the service layer. Will be scanned by spring and holds biz logic. Controllers use service to data
public class DemoServiceImpl implements DemoService {

    @Override
    public String getHelloMessage(String user) {
        return ("Hello "  + user);
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application.";
    }
}
