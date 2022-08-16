package util;

import java.security.SecureRandom;
import java.util.Base64;

public class Token {
    protected final SecureRandom secureRandom = new SecureRandom();
    protected final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public String generateToken(){
        byte[] bytes = new byte[24];
        secureRandom.nextBytes(bytes);
        return base64Encoder.encodeToString(bytes);
    }
}
