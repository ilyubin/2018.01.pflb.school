package ok.automation.tech.extensions;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger("|");

    public static String getMD5(final String text) {
        String hash = DigestUtils
                .md5Hex(text).toUpperCase();
        LOGGER.info("getMD5Hash | {} | {} |", text, hash);
        return hash;
    }

}
