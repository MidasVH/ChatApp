package controller;

import domain.Conversation;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getChat extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        if(user != null){
            String userid = request.getParameter("userId");
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

                String result = this.ListToJSON(found.messages);
                response.setContentType("application/json");
                response.getWriter().write(result);
            }
        }
        return "";
    }
}
