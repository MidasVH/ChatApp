package controller;

import domain.Conversation;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMessage extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person) request.getSession().getAttribute("user");

        if(user != null){
            String userid = request.getParameter("userId");
            Person p2 = getPersonService().getPerson(userid);

            Conversation found = null;

            if(user.getFriends().contains(getPersonService().getPerson(userid))){
                for(Conversation c : this.getPersonService().conversations){
                    if((c.p1.getUserId().equals(user.getUserId()) && c.p2.getUserId().equals(userid)) ||
                            (c.p2.getUserId().equals(user.getUserId()) && c.p1.getUserId().equals(userid))){
                        found = c;
                        break;
                    }
                }
                if(found == null){
                    found = new Conversation(user, getPersonService().getPerson(userid));
                    this.getPersonService().conversations.add(found);
                }

                if(!request.getParameter("message").isEmpty()){
                    found.messages.add(user.getUserId()+": " + request.getParameter("message"));

                }
            }
        }
        response.setContentType("application/json");
        return null;
    }
}
