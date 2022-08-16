package client;

import request.Request;
import request.RequestType;
import response.Response;
import util.Mapper;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServerController {
    protected InetAddress inetAddress;
    protected int port;
    protected Socket socket;
    protected Scanner in;
    protected PrintStream out;

    public ServerController(InetAddress inetAddress, int port) {
        this.inetAddress=inetAddress;
        this.port=port;
    }

    public void sendRequest(Request request){
        String requestString = Mapper.Serialize(request);
        out.println(countLines(requestString));
        out.println(requestString);
        out.flush();
    }

    public void connectToServer() {
        try {
            socket = new Socket(inetAddress, port);
            out = new PrintStream(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response sendLoginRequest(String username, String password) {
        Request request = new Request(RequestType.LOGIN);
        request.addData("username", username);
        request.addData("password", password);
        sendRequest(request);
        Response response = receiveMessage();
        return response;
    }

    private int countLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return  lines.length;
    }

    private Response receiveMessage() {
        String line = in.nextLine();
        String responseString = "";
        if (in.hasNextLine() && !line.equals("")) {
            int size = Integer.parseInt(line);
            String st = "";
            for (int i = 0; i < size; i++){
                responseString += in.nextLine();
                responseString += "\n";
            }
        }
        Response response = Mapper.Deserialize(responseString);
        return response;
    }

    public Response sendAddContactRequest(String contactID) {
        Request request = new Request(RequestType.ADD_CONTACT);
        request.addData("UniversityCode",contactID);
        sendRequest(request);
        Response response = receiveMessage();
        return response;
    }

    public Response sendCreateChatRequest(String contactID) {
        Request request = new Request(RequestType.CREATE_CHAT);
        request.addData("UniversityCode",contactID);
        sendRequest(request);
        Response response = receiveMessage();
        return response;
    }

    public Response sendGetChatRequest(String contactID) {
        Request request = new Request(RequestType.GET_CHAT);
        request.addData("UniversityCode",contactID);
        System.out.println(request);
        sendRequest(request);
        Response response = receiveMessage();
        return response;
    }

    public Response sendTextMessageRequest(String text) throws UnknownHostException {
        Request request = new Request(RequestType.SEND_TEXT_MESSAGE);
        request.addData("text",text);
        request.addData("receiver",Client.getInstance().getChatController().getContactName().split("\n")[1].strip());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateString = formatter.format(date);
        request.addData("date",dateString);
        sendRequest(request);
        Response response = receiveMessage();
        return response;
    }

    public Response sendImageMessageRequest(String text, String content) throws UnknownHostException {
        Request request = new Request(RequestType.SEND_MEDIA_MESSAGE);
        request.addData("text",text);
        request.addData("receiver",Client.getInstance().getChatController().getContactName().split("\n")[1].strip());
        request.addData("content", content);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateString = formatter.format(date);
        request.addData("date",dateString);
        sendRequest(request);
        Response response = receiveMessage();
        return response;
    }
}
