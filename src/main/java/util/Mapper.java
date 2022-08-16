package util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import request.Request;
import response.Response;

public class Mapper {
    public static String Serialize(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String Json = "";
        Json = gson.toJson(obj);
        return Json;
    }

    public static Response Deserialize(String serial) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        Response response = gson.fromJson(serial, Response.class);
        return response;
    }
}