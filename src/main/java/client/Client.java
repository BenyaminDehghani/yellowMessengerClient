package client;

import APIs.SceneChanger;
import messages.Chat;
import messages.ChatController;
import response.Response;
import users.User;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class Client {
    protected ServerController serverController;
    protected InetAddress inetAddress;
    protected int port;
    private List<String> contacts;
    private List<String> chats;
    private ChatController chatController;
    private int currentFile;

    private static Client client;

    public static Client getInstance() throws UnknownHostException {
        if (client == null)
            client = new Client(InetAddress.getLocalHost(),9090);
            return client;
    }

    public Client(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
    }

    public void start() throws UnknownHostException {
        serverController = new ServerController(InetAddress.getLocalHost(),port);
        serverController.connectToServer();
//        loginCLI();
    }

//    private void loginCLI() {
//
//    }

    public Response login(String username, String password) {
        return serverController.sendLoginRequest(username, password);
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public Response requestForContact(String contactID) {
        return serverController.sendAddContactRequest(contactID);
    }

    public Response createChatRequest(String contactID) {
        return serverController.sendCreateChatRequest(contactID);
    }

    public Response getChatRequest(String contactID) {
        return serverController.sendGetChatRequest(contactID);
    }

    public Response sendTextMessageRequest(String text) throws UnknownHostException {
        return serverController.sendTextMessageRequest(text);
    }

    public Response sendImageMessageRequest(String text, String content) throws UnknownHostException {
        return serverController.sendImageMessageRequest(text, content);
    }

    public void addChat(String chatName) {
        chats.add(chatName);
    }

    public List<String> getChats() {
        return chats;
    }

    public void setChats(List<String> chats) {
        this.chats = chats;
    }

    public ChatController getChatController() {
        return chatController;
    }

    public void setChatController(ChatController chatController) {
        this.chatController = chatController;
    }

    public int getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(int currentFile) {
        this.currentFile = currentFile;
    }
}
