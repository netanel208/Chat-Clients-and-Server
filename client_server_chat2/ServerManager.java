package client_server_chat2;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * The server that can be run both as a console application or a GUI
 */
/**
 * 
 * @author Netanel
 *
 */
public class ServerManager {
	// a unique ID for each connection
	private static int uniqueId;
	// an ArrayList to keep the list of the Client
	ArrayList<ClientThread> clientsArrayList;
	// if I am in a GUI
	private server sg;
	// to display time
	private SimpleDateFormat sdf;
	// the port number to listen for connection
	private int port;
	// the boolean that will be turned of to stop the server
	private boolean keepGoing;


	/**
	 * Server constructor that receive the port to listen to for connection as parameter
	 * in console
	 * @param port
	 */
	public ServerManager(int port) {
		this(port, null);
	}

	/**
	 * Server constructor that receive the port to listen to for connection as parameter
	 * in console.
	 * @param port
	 * @param sg
	 */
	public ServerManager(int port, server sg) {
		// GUI or not
		this.sg = sg;
		// the port
		this.port = port;
		// to display hh:mm:ss
		sdf = new SimpleDateFormat("HH:mm:ss");
		// ArrayList for the Client list
		clientsArrayList = new ArrayList<ClientThread>();
	}

	/**
	 * Create socket server and wait for connection requests.
	 * Create thread of client socket recived save it in the list.
	 */
	public void start() {
		keepGoing = true;
		/* create socket server and wait for connection requests */
		try 
		{
			// the socket used by the server
			ServerSocket serverSocket = new ServerSocket(port);

			// infinite loop to wait for connections
			while(keepGoing) 
			{
				// format message saying we are waiting
				display("Server waiting for Clients on port " + port + "...");

				Socket clientSocket = serverSocket.accept();  	// accept connection
				// if I was asked to stop
				if(!keepGoing)
					break;
				ClientThread t = new ClientThread(clientSocket);  // make a thread of it
				clientsArrayList.add(t);					   	// save it in the ArrayList
				t.start();
			}
			// server was asked to stop
			try {
				serverSocket.close();
				for(int i = 0; i < clientsArrayList.size(); ++i) {
					ClientThread tc = clientsArrayList.get(i);
					try {
						tc.sInput.close();
						tc.sOutput.close();
						tc.socket.close();
					}
					catch(IOException ioE) {
						// not much server can do
					}
				}
			}
			catch(Exception e) {
				display("Exception closing the server and clients: " + e);
			}
		}
		// something went bad
		catch (IOException e) {
			String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
			display(msg);
		}
	}		
	/**
	 * For the GUI to stop the server
	 */
	protected void stop() {
		keepGoing = false;
		// connect to myself as Client to exit statement 
		// Socket socket = serverSocket.accept();
		try {
			new Socket("localhost", port);
		}
		catch(Exception e) {
			// nothing I can really do
		}
	}
	/**
	 * Display an event (not a message) to the console or the GUI
	 * @param msg
	 */
	private void display(String msg) {
		String time = sdf.format(new Date()) + " " + msg;
		if(sg == null)
			System.out.println(time);
		else
			sg.appendEvent(time + "\n");
	}
	/**
	 *  to broadcast a message to all Clients.
	 *  using MESSAGE message
	 * @param message
	 */
	private synchronized void broadcast(String message) {
		// add HH:mm:ss and \n to the message
		String time = sdf.format(new Date());
		String messageLf = time + " " + message + "\n";
		// display message on console or GUI
		if(sg == null)
			System.out.print(messageLf);

		// we loop in reverse order in case we would have to remove a Client
		// because it has disconnected
		for(int i = clientsArrayList.size(); --i >= 0;) {
			ClientThread ct = clientsArrayList.get(i);
			// try to write to the Client if it fails remove it from the list
			if(!ct.writeMsg(messageLf)) {
				clientsArrayList.remove(i);
				display("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	/**
	 * to send private message to specific client(destination).
	 * using CLIENTMESSAGE message.
	 * @param message
	 * @param destination
	 */
	private synchronized void clientMess(String message, String destination) {
		// add HH:mm:ss and \n to the message
		String time = sdf.format(new Date());
		String messageLf = time + " " + message + "\n";
		boolean found=false;
		int inOfColon = message.indexOf(":");
		String thisClientName =  message.substring(0, inOfColon);
		ClientThread thisTh = null;
		for(int i = 0; i < clientsArrayList.size();++i) {
			ClientThread ct = clientsArrayList.get(i);
			String clientName = ct.username;
			if(clientName.equals(thisClientName))
			{
				thisTh = ct;
			}
		}
		for(int i = 0; i < clientsArrayList.size();++i) {
			ClientThread ct = clientsArrayList.get(i);
			String clientName = ct.username;
			// try to write to the Client
			if(clientName.equals(destination))
			{
				found = ct.writeMsg(messageLf);
				thisTh.writeMsg(messageLf);
			}
		}
		if(!found)
		{
			thisTh.writeMsg("Not  recognize the client :"+destination);
		}
	}
	/** for a client who logoff using the LOGOUT message
	 * 
	 * @param id
	 */
	synchronized void remove(int id) {
		// scan the array list until we found the Id
		for(int i = 0; i < clientsArrayList.size(); ++i) {
			ClientThread ct = clientsArrayList.get(i);
			// found it
			if(ct.id == id) {
				clientsArrayList.remove(i);
				return;
			}
		}
	}

	/*
	 *  To run as a console application just open a console window and: 
	 * > java Server
	 * > java Server portNumber
	 * If the port number is not specified 1500 is used
	 */ 
	public static void main(String[] args) {
		// start server on port 1500 unless a PortNumber is specified 
		int portNumber = 45000;
		switch(args.length) {
		case 1:
			try {
				portNumber = Integer.parseInt(args[0]);
			}
			catch(Exception e) {
				System.out.println("Invalid port number.");
				System.out.println("Usage is: > java Server [portNumber]");
				return;
			}
		case 0:
			break;
		default:
			System.out.println("Usage is: > java Server [portNumber]");
			return;

		}
		// create a server object and start it
		ServerManager server = new ServerManager(portNumber);
		server.start();
	}

	/**
	 * Internal class.
	 *  One instance of this thread will run for each client 
	 *  
	 */
	class ClientThread extends Thread {
		// the socket where to listen/talk
		Socket socket;
		ObjectInputStream sInput;
		ObjectOutputStream sOutput;
		// my unique id (easier for deconnection)
		int id;
		// the Username of the Client
		String username;
		// the only type of message a will receive
		ChatMessage cm;
		// the date I connect
		String date;

		/**
		 * Constructore that receive clientSocket to input/write same message
		 * @param socket
		 */
		ClientThread(Socket socket) {
			// a unique id
			id = ++uniqueId;
			this.socket = socket;
			/* Creating both Data Stream */
			System.out.println("Thread trying to create Object Input/Output Streams");
			try
			{
				// create output first
				sOutput = new ObjectOutputStream(socket.getOutputStream());
				sInput  = new ObjectInputStream(socket.getInputStream());
				// read the username
				username = (String) sInput.readObject();
				display("client "+username + " entered");
			}
			catch (IOException e) {
				display("Exception creating new Input/output Streams: " + e);
				return;
			}
			// have to catch ClassNotFoundException
			// but I read a String, I am sure it will work
			catch (ClassNotFoundException e) {
			}
			date = new Date().toString() + "\n";
		}

		// what will run forever
		/**
		 * run forever. 
		 * Responsible for sending messages of various types .
		 */
		public void run() {
			broadcast("client "+this.username+" entered");
			// to loop until LOGOUT
			boolean keepGoing = true;
			while(keepGoing) {
				// read a String (which is an object)
				try {
					cm = (ChatMessage) sInput.readObject();
				}
				catch (IOException e) {
//					display(username + " Exception reading Streams: " + e);
					break;				
				}
				catch(ClassNotFoundException e2) {
					break;
				}
				// the messaage part of the ChatMessage
				String message = cm.getMessage();
				String dst = cm.getDst(); //dst user message(if exist one)
				System.out.println("the dst :"+dst);
				// Switch on the type of message receive
				switch(cm.getType()) {

				case ChatMessage.CLIENTMESSAGE:
					clientMess(username + ": " + message, dst);
					break;
				case ChatMessage.MESSAGE:
					broadcast(username + ": " + message);
					break;
				case ChatMessage.LOGOUT:
					broadcast("client "+username + " leaved");
					sg.appendEvent("client "+username + " leaved");
					keepGoing = false;
					break;
				case ChatMessage.WHOISIN:
					writeMsg("List of the users connected at " + sdf.format(new Date()) + "\n");
					// scan al the users connected
					for(int i = 0; i < clientsArrayList.size(); ++i) {
						ClientThread ct = clientsArrayList.get(i);
						writeMsg((i+1) + ") " + ct.username + " since " + ct.date);
					}
					break;
				}
			}
			// remove myself from the arrayList containing the list of the
			// connected Clients
			remove(id);
			close();
		}

		/**
		 * try to close everything
		 */
		private void close() {
			// try to close the connection
			try {
				if(sOutput != null) sOutput.close();
			}
			catch(Exception e) {}
			try {
				if(sInput != null) sInput.close();
			}
			catch(Exception e) {};
			try {
				if(socket != null) socket.close();
			}
			catch (Exception e) {}
		}

		/**
		 *  Write a String to the Client output stream
		 * @param msg
		 * @return
		 */
		private boolean writeMsg(String msg) {
			// if Client is still connected send the message to it
			if(!socket.isConnected()) {
				close();
				return false;
			}
			// write the message to the stream
			try {
				sOutput.writeObject(msg);
			}
			// if an error occurs, do not abort just inform the user
			catch(IOException e) {
				display("Error sending message to " + username);
				display(e.toString());
			}
			return true;
		}
	}
}


