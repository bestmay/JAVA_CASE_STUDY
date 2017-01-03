package Controller;

import DAO.EmpDAO;
import POJO.Users;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syntel
 */
public class Login extends SimpleFormController {

    public Login() {
        setCommandClass(Users.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Users user = (Users) command;
        return new ModelAndView("menu", "user", user);
    }

}
