package com.apolis.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dbData")
public class DBData {
	@Value("${db.url}")
	private String url;
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
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

	@Override
	public String toString() {
		return "DBData [url=" + url + ", driverClassName=" + driverClassName + ", username=" + username + ", password="
				+ password + "]";
	}

}
