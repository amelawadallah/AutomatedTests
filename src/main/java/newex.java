import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.testng.annotations.Test;



public class newex {

	
	public void maillist() throws MessagingException{
		Properties prop = new Properties();
//		prop.setProperty("mail.imap.auth.login.disable","true");
//		prop.setProperty("mail.imap.auth.plain.disable", "true");
//		prop.setProperty("mail.imap.auth.ntlm.disable", "false");
//		prop.setProperty("mail.imap.auth.xoauth2.disable", "false");
		prop.setProperty("mail.imap.starttls.enable", "true");

//	    prop.setProperty("mail.imap.ssl.enable", "true");
//	    prop.setProperty("mail.imap.ssl.trust", "10.100.1.103");

//		prop.put("ssl.SocketFactory.provider",ExchangeSSLSocketFactory.class);
//		prop.put("mail.imap.socketFactory.class", ExchangeSSLSocketFactory.class);
		Session session = Session.getDefaultInstance(prop, null);
		session.setDebug(true);
		Store store = session.getStore("imap");
		store.connect("10.100.1.103","amal.awadallah","");
	}
	@Test
	public void newtests() throws MessagingException{
		maillist();
	}
}
