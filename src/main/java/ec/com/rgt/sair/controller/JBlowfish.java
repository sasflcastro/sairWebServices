package ec.com.rgt.sair.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

 
public class JBlowfish {
 
    public static void main(String[] args) throws Exception {
    	String h="12345678";
        System.out.println(encrypt(h));
        System.out.println(decrypt("bwqB2IU9SUU="));
    }
 
    public static String encrypt(String password){
        byte[] keyData = "1Ss992".getBytes();//(username+password).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher;
		try {
			cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	        byte[] hasil = cipher.doFinal(password.getBytes());
	        Base64 base64 = new Base64();
	        return  base64.encodeAsString(hasil);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return password;
        
    }
     
    public static String decrypt(String string) throws IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keyData = "1Ss992".getBytes();//("edwin"+"password").getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher;
		try {
			cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			Base64 base64 = new Base64();
	       byte[] hasil = cipher.doFinal(base64.decode(string));
	        return new String(hasil);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException /*| IllegalBlockSizeException | BadPaddingException | IOException*/ e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return string;
    }
}	
