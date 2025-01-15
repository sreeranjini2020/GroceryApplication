package utilities;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptUtility {
	public static SecretKey generateKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128); 
		return keyGen.generateKey();
	}

	public static String encrypt(String text, String key) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(text.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	
	public static String decrypt(String encryptedText, String key) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
		return new String(decryptedBytes);
	}
	
	public static void main(String[] args) throws Exception {
		String key = "1234567890123456"; 
		String originalText = "admin"; 
		
		String encryptedText = encrypt(originalText, key);
		System.out.println("Encrypted Text: " + encryptedText);
		
		String decryptedText = decrypt(encryptedText, key);
		System.out.println("Decrypted Text: " + decryptedText);
	}
}
