package controller;

public abstract class AsyncRequestHandler extends RequestHandler {

    public String toJSON (String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \" status \" : \" ");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }
}

