/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server_chat2;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

/**
 * @author Netanel
 */
public class Client extends javax.swing.JFrame {

	
	/**
	 * Allows writing on disk
	 */
	private static final long serialVersionUID = 3970976847258960979L;

	ClientManager client = null;
	boolean connected = false;
	/**
	 * Creates new form Client
	 */
	public Client() {
		initComponents();


	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		jToggleButton_connect = new javax.swing.JToggleButton();
		my_name = new javax.swing.JTextField();
		jLabel_name = new javax.swing.JLabel();
		jLabel_address = new javax.swing.JLabel();
		ip_ad = new javax.swing.JTextField();
		jToggleButton_showOnline = new javax.swing.JToggleButton();
		jToggleButton_clear = new javax.swing.JToggleButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea_Main = new javax.swing.JTextArea("");
		jLabel_To = new javax.swing.JLabel();
		dst = new javax.swing.JTextField();
		message_field = new javax.swing.JTextField("");
		jButton_send = new javax.swing.JButton();
		jButton_disconnect = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jToggleButton_connect.setText("Connect");
		jToggleButton_connect.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				Connect(evt);
			}
		});
		jToggleButton_connect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton1ActionPerformed(evt);
			}
		});

		my_name.setText("name");
		my_name.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				my_nameActionPerformed(evt);
			}
		});

		jLabel_name.setText("name:");

		jLabel_address.setText("address:");

		ip_ad.setText("127.0.0.1");
		ip_ad.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ip_adActionPerformed(evt);
			}
		});

		jToggleButton_showOnline.setText("Show online users");
		jToggleButton_showOnline.setEnabled(false);
		jToggleButton_showOnline.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				showonline(evt);
			}
		});

		jToggleButton_clear.setText("Clear");
		jToggleButton_clear.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				Clear(evt);
			}
		});
		jToggleButton_clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton3ActionPerformed(evt);
			}
		});

		jTextArea_Main.setColumns(20);
		jTextArea_Main.setRows(5);
		jScrollPane1.setViewportView(jTextArea_Main);

		jLabel_To.setText("TO:");

		dst.setText("NAME");
		dst.setEditable(false);
		dst.setToolTipText("");

		message_field.setText("");
		message_field.setEditable(false);
		message_field.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				message_fieldActionPerformed(evt);
			}
		});

		jButton_send.setText("Send");
		jButton_send.setEnabled(false);
		jButton_send.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				Send(evt);
			}
		});

		jButton_disconnect.setText("Disconnect");
		jButton_disconnect.setEnabled(false);
		jButton_disconnect.setToolTipText("");
		jButton_disconnect.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				Disconnect(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel_To)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dst, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(message_field, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jButton_send))
								.addGroup(layout.createSequentialGroup()
										.addGap(17)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel_name)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(my_name, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(jLabel_address)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(ip_ad, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jToggleButton_showOnline))
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
												.addGroup(Alignment.LEADING, layout.createSequentialGroup()
														.addComponent(jToggleButton_connect, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jButton_disconnect, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
//														.addComponent(jToggleButton_reset, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jToggleButton_clear, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
										.addGap(97)))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jToggleButton_connect)
								.addComponent(jButton_disconnect, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(jToggleButton_clear))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jToggleButton_showOnline)
								.addComponent(jLabel_name)
								.addComponent(my_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel_address)
								.addComponent(ip_ad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel_To)
								.addComponent(dst, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(message_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_send))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		getContentPane().setLayout(layout);

		pack();
		dst.setName("dst");
		ip_ad.setName("ip_ad");
		jButton_send.setName("jButton_send");
		jButton_disconnect.setName("jButton_disconnect");
		 jLabel_name.setName("jLabel_name");
		 jLabel_address.setName("jLabel_address");
		 jLabel_To.setName("jLabel_To");
		 jScrollPane1.setName("jScrollPane1");
		 jTextArea_Main.setName("jTextArea_Main");
		 jToggleButton_connect.setName("jToggleButton_connect");
		 jToggleButton_showOnline.setName("jToggleButton_showOnline");
		 jToggleButton_clear.setName("jToggleButton_clear");
		 message_field.setName("message_field");
		 my_name.setName("my_name");
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * This function create a new client when the event 'connect' happened,
	 * the client type is ClientManager, and start() this client.
	 * @param evt
	 */
	public void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
		// ok it is a connection request
		if(!connected)
		{
			connected = true;
			jToggleButton_connect.setEnabled(false);
			String username = my_name.getText();
			String server = ip_ad.getText();
			int port = 45000;
			// try creating a new ClientManager with GUI
			client = new ClientManager(server, port, username, this);
			dst.setEditable(true);
			message_field.setEditable(true);
			jButton_send.setEnabled(true);
			jButton_disconnect.setEnabled(true);
			jToggleButton_showOnline.setEnabled(true);
			if(!client.start()) 
				return;
		}
	}//GEN-LAST:event_jToggleButton1ActionPerformed

	/**
	 * print message on text area of this client
	 * @param msg
	 */
	public void append(String msg)
	{
		jTextArea_Main.append(msg);
		jTextArea_Main.setCaretPosition(jTextArea_Main.getText().length() - 1);
	}
	public void my_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_my_nameActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_my_nameActionPerformed

	public void ip_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_adActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_ip_adActionPerformed

	public void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jToggleButton3ActionPerformed
//	public void jToggleButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
//		// TODO add your handling code here:
//	}//GEN-LAST:event_jToggleButton3ActionPerformed

	/**
	 * Clear the text of filed. 
	 * @param evt
	 */
	public void Clear(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clear

		jTextArea_Main.setText("");
	}//GEN-LAST:event_Clear

	/**
	 * Show list of current connected clients. 
	 * @param evt
	 */
	public void showonline(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHOWONLINE
		System.out.println("showonline botten clicked");
		client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));

	}//GEN-LAST:event_SHOWONLINE

	public void Connect(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Connect
		System.out.println("connect botten clicked");

	}//GEN-LAST:event_Connect

	/**
	 * This function send the details of text fields and type of message to server by creating object of type
	 * creating object of type ChatMessage that contains all details.
	 * The send happen only if the client is already connected.  
	 * @param evt
	 */
	public void Send(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Send
		System.out.println("send botten clicked");
		// ok it is coming from the JTextField
		if(connected) {
			// just have to send the message
			if(dst.getText().equals("broadcast"))
			{
				client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, message_field.getText()));				
				message_field.setText("");
				return;
			}
			if(dst.getText() != null)
			{
				client.sendMessage(new ChatMessage(ChatMessage.CLIENTMESSAGE, message_field.getText(), dst.getText()));				
				message_field.setText("");
				return;
			}
		}

	}//GEN-LAST:event_Send

	/**
	 * This function disconnects the client from the server.
	 * @param evt
	 */
	public void Disconnect(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Disconnect
		System.out.println("Disconnect botten clicked");
		dst.setEditable(false);
		message_field.setEditable(false);
		jButton_send.setEnabled(false);
		jToggleButton_showOnline.setEnabled(false);
		client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
		jButton_disconnect.setEnabled(false);

	}//GEN-LAST:event_Disconnect

	public void message_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message_fieldActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_message_fieldActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Client().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JTextField dst;
	public javax.swing.JTextField ip_ad;
	public javax.swing.JButton jButton_send;
	public javax.swing.JButton jButton_disconnect;
	public javax.swing.JLabel jLabel_name;
	public javax.swing.JLabel jLabel_address;
	public javax.swing.JLabel jLabel_To;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JTextArea jTextArea_Main;
	public javax.swing.JToggleButton jToggleButton_connect;
	public javax.swing.JToggleButton jToggleButton_showOnline;
	public javax.swing.JToggleButton jToggleButton_clear;
	public javax.swing.JTextField message_field;
	public javax.swing.JTextField my_name;
	// End of variables declaration//GEN-END:variables
}
