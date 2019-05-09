package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Comment;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint(value = "/Blog")
public class Blog {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private static final List<Comment> comments = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        sessions.add(session);
        ObjectMapper mapper = new ObjectMapper();
        session.getBasicRemote().sendText(mapper.writeValueAsString(comments));
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(message);
        Comment comment = mapper.readValue(message, Comment.class);
        sendMessageToAll(comment);
        comments.add(comment);
    }

    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
    }

    private void sendMessageToAll(Comment comment) throws IOException {
        for(Session s : sessions){
            ArrayList<Comment> result = new ArrayList<>();
            result.add(comment);
            ObjectMapper mapper = new ObjectMapper();
            s.getBasicRemote().sendText(mapper.writeValueAsString(result));
        }
    }
}
