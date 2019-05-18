package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsersAngular extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller.setAllowSendJson();
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return personsToJSON(getPersonService().getPersons());
    }

    public String personsToJSON(List<Person> persons) {
        String json = "[";
        int i = 0;
        for (Person p : persons) {
            json += "{\"id\": \"" + p.getUserId() + "\", " +
                    "\"firstName\": \"" + p.getFirstName() + "\"," +
                    "\"lastName\": \"" + p.getLastName() + "\"," +
                    "\"status\": \"" + p.getStatus() + "\"}";
            i++;
            if (persons.size() != i) {
                json += ",";
            }
        }
        json += "]";
        return json;
    }
}
