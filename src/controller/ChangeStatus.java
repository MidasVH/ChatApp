package controller;

import domain.DomainException;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatus extends AsyncRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        Person p = (Person)request.getSession().getAttribute("user");
        try{
            p.setStatus(status);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
