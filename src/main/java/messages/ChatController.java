package messages;

import java.util.HashMap;
import java.util.List;

public class ChatController {
    protected String imageURl;
    protected String contactName;
    protected List<String> messages;
    protected HashMap<Integer,byte[]> files;

    public ChatController(String imageURl, String contactName, List<String> messages, HashMap<Integer,byte[]> files) {
        this.imageURl = imageURl;
        this.contactName = contactName;
        this.messages = messages;
        this.files = files;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public HashMap<Integer, byte[]> getFiles() {
        return files;
    }

    public void setFiles(HashMap<Integer, byte[]> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "ChatController{" +
                "imageURl='" + imageURl + '\'' +
                ", contactName='" + contactName + '\'' +
                ", messages=" + messages +
                '}';
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addFile(int id,byte[] file){
        files.put(id,file);
    }
}
