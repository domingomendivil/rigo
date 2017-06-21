package com.mag.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.inject.Inject;

import com.mag.beans.User;
import com.mag.dao.DAO;

/**
 * 
 * @author d0178 - Domingo Mendivil -
 *
 */
public class PasswordValidatorImpl implements PasswordValidator {
	
	@Inject
	private DAO dao;

	
	private final static int ROUNDS = 4000;
	
	
	private byte[] decodeBase64(String encodedString){
		return Base64.getDecoder().decode(encodedString);
	}
	
	private byte[] hash(String password,byte[] saltBytes){
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			
		    PBEKeySpec pwKey = new PBEKeySpec(password.toCharArray(), saltBytes, ROUNDS);
		    
		    PBEKey pbeKey = (PBEKey) factory.generateSecret(pwKey);
		    
		    byte[] pbkdfKey = pbeKey.getEncoded();
		    
		    return pbkdfKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean validate(String userStr,String password){
		User user  = dao.getById(userStr,User.class);
		byte[] salt = decodeBase64(user.getSalt());
		byte[] hashedPassword = hash(password,salt);
		byte[] decodedPassword = decodeBase64(user.getPassword());
		return Arrays.equals(hashedPassword,decodedPassword);
		
	}	

}
