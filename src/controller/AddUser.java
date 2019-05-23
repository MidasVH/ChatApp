package controller;

import domain.DomainException;
import domain.Gender;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class AddUser extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        List<String> errors = new ArrayList<>();

        try{
            String userid = request.getParameter("email");
            p.setUserId(userid);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
        try{
            String firstname = request.getParameter("firstname");
            p.setFirstName(firstname);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
        try{
            String lastname = request.getParameter("lastname");
            p.setLastName(lastname);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
        try{
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            if(!password.equals(confirmPassword)){
                throw new DomainException("Passwords don't match");
            }
            p.setHashedPassword(password);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
        try{
            String gender = request.getParameter("gender");
            p.setGender(Gender.valueOf(gender.toUpperCase()));
        }catch(Exception e){
            errors.add(e.getMessage());
        }
        try{
            String sBirthday = request.getParameter("birthday");
            LocalDate birthday = LocalDate.parse(sBirthday);
            p.setBirthday(birthday);
        }catch(Exception e){
            errors.add(e.getMessage());
        }

        p.setStatus("offline");

        if(errors.isEmpty()){
            try{
                getPersonService().addPerson(p);
            }catch(Exception e){
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
            }
        }else{
            request.setAttribute("errors", errors);
            return "addUser.jsp";
        }
        return "index.jsp";
    }
}
