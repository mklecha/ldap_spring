package com.ensta.asi34.model;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(
        base = "ou=people",
        objectClasses = {"person", "inetOrgPerson", "top"})
public class User {
    @Id
    private Name id;

    private @Attribute(name = "cn")
    String username;
    private @Attribute(name = "userPassword")
    String password;
    private @Attribute(name = "isUsing2FA")
    boolean isUsing2FA;
    private @Attribute(name = "secret")
    String secret;

    public boolean isUsing2FA() {
		return isUsing2FA;
	}

	public void setUsing2FA(boolean isUsing2FA) {
		this.isUsing2FA = isUsing2FA;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Name getId() {
        return id;
    }

    public void setId(Name id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}