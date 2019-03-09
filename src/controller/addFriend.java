package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addFriend extends AsyncRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person)request.getSession().getAttribute("user");
        if(user != null){
            String userid = request.getParameter("friend");
            Person friend = getPersonService().getPerson(userid);
            user.addFriend(friend);
            friend.addFriend(user);
        }
        return null;
    }
}
