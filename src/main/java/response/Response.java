package response;

import java.util.HashMap;

public class Response {
    private ResponseStatus responseStatus;
    private HashMap<String, Object> data;
    private String errorMessage;

    public Response() {
    }

    public Response(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void addData(String key, Object value){
        data.put(key,value);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseStatus=" + responseStatus +
                ", data=" + data +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
