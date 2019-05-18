package controller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public abstract class AsyncRequestHandler extends RequestHandler {

    public String toJSON (String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\": \"");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }


    public String ListToJSON(List list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}

