package com.qa.ctf.constant;

/**
 * Message Class representing various messages related to functionalities in the application.
 *
 * @author Jagatheshwaran N
 * @version 1.0
 */
public class Message {

    /**
     * Error message when the username is not registered on the site.
     */
    public static final String LOGIN_USERNAME_ERROR = "Error: The username (.*?) is not registered on this site. If you are unsure of your username, try your email address instead.";

    /**
     * Error message when the password for the provided username is incorrect.
     */
    public static final String LOGIN_PASSWORD_ERROR = "Error: The password you entered for the username (.*?) is incorrect. Lost your password?";

}
