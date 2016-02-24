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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.sf.memoranda.Login;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Local;

public class NewPasswordDialog extends JFrame {
	  
	  JPanel panel1 = new JPanel();
	  BorderLayout borderLayout1 = new BorderLayout();
	  JButton jButton1 = new JButton();
	  JButton jButton2 = new JButton();
	  Border border1;
	  Border border2;
	  Border border3;
	  JPanel jPanel1 = new JPanel();
	  JPanel panLeft = new JPanel(new BorderLayout());
	  JPanel panRight = new JPanel(new BorderLayout());
	  JLabel textLabel = new JLabel();
	  JLabel textLabel1 = new JLabel();
	  JLabel textLabel2 = new JLabel();
	  Border border4;
	  JPasswordField password1 = new JPasswordField(10);
	  JPasswordField password2 = new JPasswordField(10);
	  

	  public NewPasswordDialog() {
	    this.setTitle("New Password");
	    try {
	      jbInit();
	      pack();
	    }
	    catch(Exception ex) {
	      new ExceptionDialog(ex);
	    }
	    textLabel.setText("  ");
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
	    
	    jButton1.setText(Local.getString("Submit"));
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
	    jButton2.setText(Local.getString("Cancel"));
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
	    
	    panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    panLeft.setBackground(new Color(251, 197, 63));
	    panRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    panRight.setBackground(new Color(251, 197, 63));
	    
	    
	    panel1.setBorder(border4);
	    panel1.setMinimumSize(new Dimension(200, 200));
	    panel1.setPreferredSize(new Dimension(200, 200));
	    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    getContentPane().add(panel1);
	    panel1.add(jPanel1,  BorderLayout.SOUTH);
	    panel1.add(panLeft, BorderLayout.WEST);
	    panel1.add(panRight, BorderLayout.EAST);
	   
	    textLabel1.setText("Enter Password:");
	    panLeft.add(textLabel1,BorderLayout.NORTH);
	    panLeft.add(password1, BorderLayout.SOUTH);
	    
	    textLabel2.setText("Confirm:");
	    panRight.add(textLabel2,BorderLayout.NORTH);
	    panRight.add(password2, BorderLayout.SOUTH);
	    
	    jPanel1.add(jButton1, null);
	    jPanel1.add(jButton2, null);
	    jPanel1.setBackground(new Color(251, 197, 63));
	    panel1.add(textLabel, BorderLayout.NORTH);
	    
	  
	  }

	  void jButton1_actionPerformed(ActionEvent e) {
	      if(password1.getText().equals(password2.getText()))
	      {
	    	  if(password1.getText().equals(""))
		       {
		       Configuration.put("USER_PASSWORD", "none");
		       Configuration.saveConfig();
		       }
	    	  else
	    	  {
	    	  Configuration.put("USER_PASSWORD", password1.getText());
	    	  Configuration.saveConfig();
	    	  }
	    	  Login.cancelled();
	    	  this.dispose();
	      }
	      else
	      {
	    	  textLabel.setText("Passwords do not match");
	      }
	  }
	  
	  void jButton2_actionPerformed(ActionEvent e) {
	       this.dispose();
	       if(Configuration.get("USER_PASSWORD").equals("default")
	    		   ||Configuration.get("USER_PASSWORD").equals(""))
	       {
	       Configuration.put("USER_PASSWORD", "none");
	       Configuration.saveConfig();
	       }
	       Login.cancelled();
	  } 

}

