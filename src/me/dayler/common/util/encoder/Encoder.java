/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dayler.common.util.encoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import me.dayler.common.util.Parameters;


/**
 * @author clvelarde
 */
public final class Encoder {

    private static final String SHA_256 = "SHA-256";

    private static final String UTF_8 = "UTF-8";

    private static final String MD5 = "MD5";

    public static byte[] encodeSHA256(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        Parameters.checkBlankString(key, "key");

        MessageDigest messageSHA = MessageDigest.getInstance(SHA_256);
        messageSHA.update(key.getBytes(UTF_8));

        return messageSHA.digest();
    }

    public static String encodeBase64(byte[] messToEncode) {
        Parameters.checkNull(messToEncode, "messToEncode");

        return new BASE64Encoder().encode(messToEncode);
    }

    public static byte[] decodeBase64(String messToDecode) throws IOException {
        Parameters.checkBlankString(messToDecode, "messToDecode");

        return new BASE64Decoder().decodeBuffer(messToDecode);
    }

    public static byte[] encodeMD5(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(MD5);
        byte[] hash = md.digest(message.getBytes(UTF_8));

        return hash;
    }
}
