package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getStatus extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller.setAllowSendJson();
        Person p = (Person)request.getSession().getAttribute("user");
        System.out.println(p.getStatus());
        if(p.getStatus() != null){
            return toJSON(p.getStatus());
        }else{
            return toJSON("offline");
        }


    }
}
