package request;

import java.util.HashMap;

public class Request {
    protected RequestType requestType;
    protected HashMap <String, Object> data;

    public Request(RequestType requestType) {
        this.requestType = requestType;
        this.data=new HashMap<>();
    }

    public void addData(String key, Object value){
        data.put(key, value);
    }
}
