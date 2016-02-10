/**
 * DefaultEventNotifier.java Created on 10.03.2003, 21:18:02 Alex Package:
 * net.sf.memoranda
 * 
 * @author Alex V. Alishevskikh, alex@openmechanics.net Copyright (c) 2003
 *         Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import net.sf.memoranda.ui.EventNotificationDialog;
import net.sf.memoranda.util.Configuration;

/**
 *  
 */
/*$Id: DefaultEventNotifier.java,v 1.4 2004/01/30 12:17:41 alexeya Exp $*/
public class DefaultEventNotifier implements EventNotificationListener {

	/**
	 * Constructor for DefaultEventNotifier.
	 */
	public DefaultEventNotifier() {
		super();
	}

	/**
	 * @see net.sf.memoranda.EventNotificationListener#eventIsOccured(net.sf.memoranda.Event)
	 */
	public void eventIsOccured(Event ev) {		
		new EventNotificationDialog(
			"Memoranda event",
			ev.getTimeString(),
			ev.getText());
		
		if(ev.getEmailNotify()){
		new EventEmail(Configuration.get("USER_EMAIL").toString(),ev.getText());
		try {
			EventEmail.sendNewEmail();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		}
	}
	/**
	 * @see net.sf.memoranda.EventNotificationListener#eventsChanged()
	 */
	public void eventsChanged() {
		//
	}

	
}
