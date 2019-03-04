package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatus extends AsyncRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        System.out.println(status);
        Person p = (Person)request.getSession().getAttribute("user");
        p.setStatus(status);
        request.getSession().setAttribute("user", p);
        return toJSON(status);
    }


}
