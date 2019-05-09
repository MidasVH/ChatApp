package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Conversation {
    public Person p1, p2;
    public List<String> messages;

    public Conversation(Person p1, Person p2){
        this.p1 = p1;
        this.p2 = p2;
        messages = new ArrayList<>();
    }
}
