package net.sf.memoranda.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class Encryption {
	
	byte[] buf = new byte[1024];
	  Cipher ecipher;
	  Cipher dcipher;
	  byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35,
		      (byte) 0xE3, (byte) 0x03 };
	  
	  
	  Encryption(String encryptionKey) throws Exception{
		  
		int iterationCount = 2;
		KeySpec keySpec = new PBEKeySpec(encryptionKey.toCharArray(), salt, iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
	   
	    ecipher = Cipher.getInstance(key.getAlgorithm());
	    dcipher = Cipher.getInstance(key.getAlgorithm());
	    
	    AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

	    ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
	    dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	  }
	  
	  public void encrypt(InputStream in, OutputStream out)  throws Exception{
		 
		 	out = new CipherOutputStream(out, ecipher);

		    int numRead = 0;
		    while ((numRead = in.read(buf)) >= 0) {
		      out.write(buf, 0, numRead);
		    }
		    out.close();
		   
		  }
	  
	  public String decrypt(InputStream in)  throws Exception{
		    in = new CipherInputStream(in, dcipher);

		    StringBuilder builder = new StringBuilder();
		    int ch;
		    while((ch =in.read()) != -1){
		        builder.append((char)ch);
		    }

		    return builder.toString();
		  }

}
