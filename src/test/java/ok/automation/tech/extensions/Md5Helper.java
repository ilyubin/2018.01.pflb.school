package ok.automation.tech.extensions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Helper {
    private static final Logger LOGGER = LoggerFactory.getLogger("|");
    public static String getMD5Hash(final String text) {
        MessageDigest md = initMessageDigest();
        byte[] bytes = md.digest(text.getBytes());
        String result = "";
        for (int i = 0; i < bytes.length; ++i)
            result += Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3);
        LOGGER.info("getMD5Hash | {} | {} |", text, result);
        return result;
    }
    private static MessageDigest initMessageDigest() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md;
    }
}
