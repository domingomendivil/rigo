package com.mag.security;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;

import com.mag.dao.DAO;

@RunWith(MockitoJUnitRunner.class)
public class BasicAuthenticatorTest {
	
	@Mock
	private PasswordValidator passwordValidator;
	
	@InjectMocks
	private BasicAuthenticator basicAuthenticator;
	
	@Mock
	private DAO dao;
	
	@Test
	public void test1(){
		
	}
	
	//Test with invalid password, should throw AuthenticationException
	
	/**public void test1() throws AuthenticationException{
		String authorization =  Base64.getEncoder().encodeToString("d0178:pepe".getBytes());
		Mockito.when(passwordValidator.validate("d0178","pepe")).thenReturn(false);
		basicAuthenticator.getUser(authorization);
	}
	
	//test with valid password, should return the user data given by the dao
	
	public void test2() throws AuthenticationException{
		String authorization = Base64.getEncoder().encodeToString("d0178:pepe".getBytes());
		Mockito.when(passwordValidator.validate("d0178","pepe")).thenReturn(true);
		basicAuthenticator.getUser(authorization);
	}
	
	//test with null value, should return AuthenticationException
	
	public void test3() throws AuthenticationException{
		String authorization = Base64.getEncoder().encodeToString("d0178:pepe".getBytes());
		Mockito.when(passwordValidator.validate("d0178","pepe")).thenReturn(false);
		basicAuthenticator.getUser(authorization);
	}
	
	//test with invalid codification, should return AuthenticationException
	public void test4() throws AuthenticationException{
		basicAuthenticator.getUser("a");
	}
	
	//test, but user does not exist, should return AuthenticationException
	public void test5() throws AuthenticationException{
		basicAuthenticator.getUser("a");
	}**/

	
	
	

}
