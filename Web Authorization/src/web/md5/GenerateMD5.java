package web.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class GenerateMD5 {
	public String generateMD5(String password) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String hashResult = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
		
		return hashResult;
	}

}
