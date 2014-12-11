package com.jabber.utils;



/**
 * @author rowantan Please access any configuration value from here
 *         and methods
 * 
 */
public class Config {
	 // SERVER ADDRESS
	public static final String _SERVER_ADDRESS = "";	
	public static final String _TEST_SERVER_ADDRESS = "http://www.jabber-test.netai.net/";
	
	public static final String LOGIN_URL = _TEST_SERVER_ADDRESS + "login.php";
	public static final String REGISTER_URL = _TEST_SERVER_ADDRESS + "register.php";
	
	
	// SHARED PREF. FILENAME
	public static final String SP_PATH = "com.sp.jabber."; 
	
	/*Ê
	 * EXTRA_BUNDLE Keys
	 */
	public static final String EXTRA_BUNDLE_ = "com.xb.jabber.";
	
	
	
	/*
	 * TAGS
	 */
	
	public static final String TAG_SUCCESS = "success";
	public static final String TAG_MESSAGE = "message";
	
	/*
	 * Share Preference KEYS
	 */
	// User Related
	public static final String SP_USERNAME = SP_PATH + "username";
	public static final String SP_PASSWORD = SP_PATH + "password";
	public static final String SP_NAME = SP_PATH + "name";
	public static final String SP_EMAIL = SP_PATH + "email";
	public static final String SP_NATIONALITY = SP_PATH + "nationality";
	public static final String SP_GENDER = SP_PATH + "gender";
	public static final String SP_DOB = SP_PATH + "dob";
	
	

	public static final String SP_LOGGED_IN = SP_PATH + "logged_in";
	public static final String SP_SESSION_TOKEN = SP_PATH + "session_token";

	// Topics
	public static final String SP_TOPIC = SP_PATH + "topic";
	public static final String SP_COMMENT = SP_PATH + "comment";
	

	/*
	 * USE: getSharedPreferences(_SP_NAME, Context.MODE_PRIVATE).edit()
	 * .putString(SP_SESSION_TOKEN, token).commit();
	 */
	

	/*
	 * REQUEST CODE
	 */
	public static final int REQUEST_CREATE_TOPIC= 0;

	
	
}
