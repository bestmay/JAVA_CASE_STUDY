package Controller;

import POJO.Users;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class Authentication extends SimpleFormController{
    
    public Authentication(){
        setCommandClass(Users.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Users user = (Users)command;
        return new ModelAndView("Menu","user",user);
    }
            
           
}
