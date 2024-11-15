package Utils;

import java.util.Base64;

public class encodeBase {
    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

}
