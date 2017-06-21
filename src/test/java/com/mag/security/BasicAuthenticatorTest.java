package com.mag.security;

import static org.mockito.Mockito.when;

import java.util.Base64;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mag.beans.User;
import com.mag.dao.DAO;

@RunWith(MockitoJUnitRunner.class)
public class BasicAuthenticatorTest {
	
	@Mock
	private PasswordValidator passwordValidator;
	
	@InjectMocks
	private BasicAuthenticator basicAuthenticator;
	
	@Mock
	private DAO dao;

	
	//Test with invalid password, should throw AuthenticationException
	@Test(expected=AuthenticationException.class)
	public void test1() throws AuthenticationException{
		String authorization =  Base64.getEncoder().encodeToString("d0178:pepe".getBytes());
		when(passwordValidator.validate("d0178","pepe")).thenReturn(false);
		basicAuthenticator.getUser(authorization);
	}
	
	//test with valid password, should return the user data given by the dao
	@Test
	public void test2() throws AuthenticationException{
		String authorization = Base64.getEncoder().encodeToString("d0178:pepe".getBytes());
		when(passwordValidator.validate("d0178","pepe")).thenReturn(true);
		User aUser = new User();
		aUser.setUserName("d0178");
		when(dao.getById("d0178",User.class)).thenReturn(aUser);
		User res = basicAuthenticator.getUser(authorization);
		Assert.assertEquals(res.getUserName(),aUser.getUserName());
	}
	
	//test with null value, should return AuthenticationException
	
	@Test(expected=AuthenticationException.class)
	public void test3() throws AuthenticationException{
		String authorization = Base64.getEncoder().encodeToString("d0178:pepe".getBytes());
		when(passwordValidator.validate("d0178","pepe")).thenReturn(false);
		basicAuthenticator.getUser(authorization);
	}
	
	//test with invalid codification, should return AuthenticationException
	@Test(expected=AuthenticationException.class)
	public void test4() throws AuthenticationException{
		basicAuthenticator.getUser("a");
	}
	
	//test, but user does not exist, should return AuthenticationException
	@Test(expected=AuthenticationException.class)
	public void test5() throws AuthenticationException{
		basicAuthenticator.getUser("a");
	}

	
	
	

}
