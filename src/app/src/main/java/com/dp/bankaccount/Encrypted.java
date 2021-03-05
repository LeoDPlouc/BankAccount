package com.dp.bankaccount;

import android.util.Base64;
import android.util.Xml;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encrypted {
    //superPASSWORD1234
    //Jean

    static String passwordHash = "��TNe�\u0011Tq�\u0017w�\"&�\u0016\u0017+&ރ6k�)�\u0001\u000E�w@";
    static String usernameHash = "V�O� �4:��ʨy=������\u000F\u0012N9}f\u0001\u0012$\\";
    static String apiURL = "aHR0cHM6Ly82MDEwMmYxNjZjMjFlMTAwMTcwNTAxMjgubW9ja2FwaS5pby9sYWJiYmFuay9hY2NvdW50cw==";

    public static String getUrl() {
        return new String(Base64.decode(apiURL,0));
    }

    public static boolean verifyCredential(String username, String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String pwdig = new String(digest.digest(password.getBytes()));
            String undig = new String(digest.digest(username.getBytes()));

            if(passwordHash.equals(pwdig) &&
            usernameHash.equals(undig))
                return true;
            else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
