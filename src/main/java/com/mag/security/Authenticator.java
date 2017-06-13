package com.mag.security;

import com.mag.beans.User;

public interface Authenticator {
	
	public User getUser(String authorization) throws AuthenticationException;

}
