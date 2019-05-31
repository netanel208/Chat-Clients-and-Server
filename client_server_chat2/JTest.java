package client_server_chat2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;

import org.junit.jupiter.api.Test;

class JTest {


	server guiS = new server();
	Client guiC = new Client();
	@Test
	/**
	 * test the correctness of connect button 
	 */
	void testConnectAndDisconnect() {
		Component[] arr = guiC.getContentPane().getComponents();
		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.println(arr[i].getName()+", ");
		}
		System.out.println("\ngui server compotents:\n");
		Component[] arr1 = guiS.getContentPane().getComponents();
		for(int i = 0 ; i < arr1.length ; i++)
		{
			System.out.println(arr1[i].getName()+", ");
		}

		int countS = 0;  //count the valid case
		try{
			guiS.startServer(null);
			countS++;
		}
		catch(Exception e){}
		try {
			guiC.my_name.setText("momo");
			countS++;
		}
		catch(Exception e) {}
		try {
			guiC.jToggleButton1ActionPerformed(null); //connected
			guiC.Disconnect(null);//disconnected
			countS++;
		}
		catch(Exception e) {}
		assertEquals(3, countS);
	}

	@Test
	void testSendWithoutConnect()
	{
		Component[] arr = guiC.getContentPane().getComponents();
		Component[] arr1 = guiS.getContentPane().getComponents();
		int count = 0;
		try {
			guiC.dst.setText("momo");
			guiC.jToggleButton1ActionPerformed(null); //try connect
			guiC.message_field.setText("hello!");
			guiC.Send(null);    //cant connect and send! hence count=0(exception)
			count++;
		}
		catch(Exception e){}
		assertEquals(0, count);
	}
	@Test
	void testSendWithConnect()
	{
		Component[] arr = guiC.getContentPane().getComponents();
		Component[] arr1 = guiS.getContentPane().getComponents();
		int count = 0;
		try {
			guiS.startServer(null);
			guiC.my_name.setText("momo");
			guiC.jToggleButton1ActionPerformed(null); //try connect
			Client guiC1 = new Client();
			guiC.my_name.setText("mimi");
			guiC1.jToggleButton1ActionPerformed(null); //try connect
			guiC.dst.setText("mimi");
			guiC.message_field.setText("hello!");    //////private message//////
			guiC.Send(null);    //can connect and send! hence count=1(no exception)
			guiC.Disconnect(null);//disconnected
			guiC1.Disconnect(null);//disconnected
			count++;
		}
		catch(Exception e){}
		assertEquals(1, count);
	}
}
