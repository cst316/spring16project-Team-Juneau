package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.sf.memoranda.Login;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Local;

public class NewLoginDialog extends JFrame {
	  
	  JPanel panel1 = new JPanel();
	  BorderLayout borderLayout1 = new BorderLayout();
	  JButton jButton1 = new JButton();
	  JButton jButton2 = new JButton();
	  Border border1;
	  Border border2;
	  Border border3;
	  JPanel jPanel1 = new JPanel();
	  JLabel textLabel = new JLabel();
	  
	  
		
	  Border border4;

	  public NewLoginDialog() {
	    this.setTitle("New user Password");
	    try {
	      jbInit();
	      pack();
	    }
	    catch(Exception ex) {
	      new ExceptionDialog(ex);
	    }
	    textLabel.setText("<html>Hello, new user!<br><br>"
	    		+ "Would you like to set a pssword?<br><br>");
	    this.setSize(300,150);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);    
	    this.toFront();
	    this.requestFocus();
	    
	  }

	  void jbInit() throws Exception {
	    this.setResizable(false);
	    this.setIconImage(new ImageIcon(EventNotificationDialog.class.getResource("resources/icons/jnotes16.png")).getImage());
	    this.getContentPane().setBackground(new Color(251, 197, 63));
	    border2 = BorderFactory.createEmptyBorder(0,30,0,30);
	    border3 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 142)),BorderFactory.createEmptyBorder(0,30,0,30));
	    border4 = BorderFactory.createEmptyBorder(10,10,0,10);
	    panel1.setLayout(borderLayout1);
	    panel1.setBackground(new Color(251, 197, 63));
	    
	    jButton1.setText(Local.getString("Yes"));
	    jButton1.setBounds(150, 415, 95, 30);
	    jButton1.setPreferredSize(new Dimension(95, 30));
	    jButton1.setBackground(new Color(69, 125, 186));
	    jButton1.setForeground(Color.white);
	    jButton1.setDefaultCapable(true);
	    jButton1.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        jButton1_actionPerformed(e);
	      }
	    });
	    jButton2.setText(Local.getString("No"));
	    jButton2.setBounds(150, 415, 95, 30);
	    jButton2.setPreferredSize(new Dimension(95, 30));
	    jButton2.setBackground(new Color(69, 125, 186));
	    jButton2.setForeground(Color.white);
	    jButton2.setDefaultCapable(true);
	    jButton2.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        jButton2_actionPerformed(e);
	      }
	    });
	    
	    
	    panel1.setBorder(border4);
	    panel1.setMinimumSize(new Dimension(300, 200));
	    panel1.setPreferredSize(new Dimension(300, 200));
	    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    getContentPane().add(panel1);
	    panel1.add(jPanel1,  BorderLayout.SOUTH);
	    jPanel1.add(jButton1, null);
	    jPanel1.add(jButton2, null);
	    jPanel1.setBackground(new Color(251, 197, 63));
	    panel1.add(textLabel, BorderLayout.NORTH);   
	    
	  
	    
	  }

	  void jButton1_actionPerformed(ActionEvent e) {
	       this.dispose();
	       new NewPasswordDialog();
	  }
	  
	  void jButton2_actionPerformed(ActionEvent e) {
	       this.dispose();
	       Configuration.put("USER_PASSWORD", "none");
	       Configuration.saveConfig();
	       Login.cancelled();
	  } 

}
