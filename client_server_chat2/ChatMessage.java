package client_server_chat2;

import java.io.*;
/**
 * This class defines the different type of messages that will be exchanged between the
 * Clients and the Server. 
 * When talking from a Java Client to a Java Server a lot easier to pass Java objects, no 
 * need to count bytes or to wait for a line feed at the end of the frame
 */
public class ChatMessage implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The different types of message sent by the Client
	 WHOISIN to receive the list of the users connected
	 MESSAGE an broadcast message
	 LOGOUT to disconnect from the Server
	 CLIENTMESSAGE an private message
	 */
	static final int WHOISIN = 0, MESSAGE = 1,CLIENTMESSAGE =3, LOGOUT = 2;
	private int type;
	private String message;
	private String dst = "";
	
	// constructors
	/**
	 * constructor
	 * @param type
	 * @param message
	 */
	ChatMessage(int type, String message) {
		this.type = type;
		this.message = message;
	}
	/**
	 * constructor
	 * @param type
	 * @param message
	 * @param dst
	 */
	ChatMessage(int type, String message, String dst) {
		this.type = type;
		this.message = message;
		this.dst = dst;
	}
	
	// getters
	/**
	 * 
	 */
	int getType() {
		return type;
	}
	/**
	 * 
	 * @return
	 */
	String getMessage() {
		return message;
	}
	/**
	 * 
	 * @return
	 */
	String getDst() {
		return dst;
	}
}

