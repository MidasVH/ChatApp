package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class addFriend extends AsyncRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller.setAllowSendJson();
        Person user = (Person)request.getSession().getAttribute("user");
        if(user != null){
            String userid = request.getParameter("friend");
            Person friend = getPersonService().getPerson(userid);
            user.addFriend(friend);
            friend.addFriend(user);
        }
        response.setContentType("application/json");
        return SetToJSON(user.getFriends());
    }

    public String SetToJSON(Set<Person> friends) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(friends);
    }
}
