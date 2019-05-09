package controller;

import domain.Person;
import org.apache.taglibs.standard.extra.spath.ASCII_CharStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

public class getFriends extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person)request.getSession().getAttribute("user");
        if(user != null){
            List<Person> friends = new ArrayList<>(user.getFriends());
            for(Person p : friends){
                if(p.getStatus() == null){
                    p.setStatus("offline");
                }
            }
            String result = this.ListToJSON(friends);
            response.getWriter().write(result);
        }

        return null;
    }
}
