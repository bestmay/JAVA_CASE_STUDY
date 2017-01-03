/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

/**
 *
 * @author LS5002117
 */
import POJO.Users;
import DAO.EmpDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        Users user = (Users) target;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO empDAO = (EmpDAO) ctx.getBean("EmpDAO");
        if (!empDAO.loginCheck(user.getUsername(), user.getPassword())) {
            errors.rejectValue("username","username.incorrect");
        }
    }

}
