package com.hakim.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class Sha256PasswordEncryptor implements PasswordEncryptor{

    @Override
    public String encrypt(String password) {
        String encryption=null;
        try {
            MessageDigest digest=MessageDigest.getInstance("sha-256");
            var bytes=digest.digest(password.getBytes(StandardCharsets.UTF_8));
            encryption=convertToHex(bytes);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha256PasswordEncryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return encryption;
    }
    
    private String convertToHex(byte[] chars){
        StringBuilder sb=new StringBuilder();
        
        for(byte b:chars){
            String hex=Integer.toHexString(0xff & b);
            if(hex.length()==1){
                sb.append('0');
            }
            sb.append(hex);
        }
        
        return sb.toString();
    }
    
}