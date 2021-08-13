package edu.group9.bank.config;

/**
 * This class Consist of Configuration details of DB instance
 * @author Group9(Ankita, Doshi Pratik, Duraipandi Vasanth, Kaur Awalpreet, Pabbathi Vishnuvardhan Reddy)
 *
 *
 */
public class DbConfig {

private String jdbcDriverClassName;
private String jdbcUrl;
private String jdbcUserName;
private String jdbcPassword;
private static DbConfig instance =null;
/**
 * @param jdbcDriverClassName
 * @param jdbcUrl
 * @param jdbcUserName
 * @param jdbcPassword
 */
/**
 * @return the instance if available else create a new instance
 */
public static void setInstance(String jdbcDriver, String url, String username, String pwd) {
	if (instance == null) {
		instance = new DbConfig(jdbcDriver,url,username,pwd);
	}
}
/**
 * @return the instance if available else create a new instance
 */
public static DbConfig getInstance() {
	return instance;
}
/**
 * deletes the instance having previous data by instantiating new object
 */
public static void deleteInstance() {
	instance = null;
}

public DbConfig(String jdbcDriverClassName, String jdbcUrl, String jdbcUserName, String jdbcPassword) {
	super();
	this.jdbcDriverClassName = jdbcDriverClassName;
	this.jdbcUrl = jdbcUrl;
	this.jdbcUserName = jdbcUserName;
	this.jdbcPassword = jdbcPassword;
}
/**
 * @return the jdbcDriverClassName
 */
public String getJdbcDriverClassName() {
	return jdbcDriverClassName;
}
/**
 * @param jdbcDriverClassName the jdbcDriverClassName to set
 */
public void setJdbcDriverClassName(String jdbcDriverClassName) {
	this.jdbcDriverClassName = jdbcDriverClassName;
}
/**
 * @return the jdbcUrl
 */
public String getJdbcUrl() {
	return jdbcUrl;
}
/**
 * @param jdbcUrl the jdbcUrl to set
 */
public void setJdbcUrl(String jdbcUrl) {
	this.jdbcUrl = jdbcUrl;
}
/**
 * @return the jdbcUserName
 */
public String getJdbcUserName() {
	return jdbcUserName;
}
/**
 * @param jdbcUserName the jdbcUserName to set
 */
public void setJdbcUserName(String jdbcUserName) {
	this.jdbcUserName = jdbcUserName;
}
/**
 * @return the jdbcPassword
 */
public String getJdbcPassword() {
	return jdbcPassword;
}
/**
 * @param jdbcPassword the jdbcPassword to set
 */
public void setJdbcPassword(String jdbcPassword) {
	this.jdbcPassword = jdbcPassword;
}
}
