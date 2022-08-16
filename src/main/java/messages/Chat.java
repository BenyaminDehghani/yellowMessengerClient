package messages;

import users.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Serializable {
    List<Message> messages;
    List<String> userCodes;

    public Chat() {
        messages = new ArrayList<>();
        userCodes = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public List<String> getUserCodes() {
        return userCodes;
    }

    public void addUserCode(String userCode){
        userCodes.add(userCode);
    }
}
