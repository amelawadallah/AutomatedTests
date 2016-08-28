import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.testng.annotations.Test;

public class fmail {
	
	public void mailf() throws MessagingException{
		Properties properties = System.getProperties();
		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		properties.put("mail.imap.socketFactory.class", SSL_FACTORY);
		
		properties.setProperty("mail.imap.user", "amal.awadallah@jawwal.ps");
		properties.setProperty("mail.imap.host", "10.100.1.103");
		properties.setProperty("mail.imap.auth.mechanisms", "");
		properties.setProperty("mail.imap.auth.login.disable","true");
		properties.setProperty("mail.imap.auth.plain.disable", "true");
		properties.setProperty("mail.imap.auth.ntlm.disable", "true");
		properties.setProperty("mail.imap.auth.xoauth2.disable", "true");
		properties.setProperty("mail.imap.proxyauth.user", "vasadmin");
		properties.setProperty("mail.imap.sasl.enable", "true");
		properties.put("mail.imap.socketFactory", "javax.net.SocketFactory");
		properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.usesocketchannels", "true");
		properties.setProperty("mail.imap.ssl.enable", "true");
		properties.setProperty("mail.imap.ssl.trust", "*");
		properties.put("mail.imap.ssl.socketFactory", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.ssl.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.starttls.enable", "true");
		properties.setProperty("mail.imap.starttls.required", "true");
		properties.setProperty("mail.imap.socketFactory.fallback", "false" );
//		properties.setProperty("mail.imap.socks.host", "10.100.1.140");
//		properties.setProperty("mail.imap.socks.port", "8080");
//		
		
		
//		properties.setProperty("mail.imaps.socketFactory.fallback", "false");
//		properties.setProperty("mail.imaps.port", "143");
//		properties.setProperty("mail.imaps.socketFactory.port", "993");
//
//	
//	    properties.setProperty("mail.imaps.host", "10.100.1.103");
//	    properties.setProperty("mail.store.protocol", "imaps");
//	    properties.put("mail.imaps.port", "143");
//	  
//	    properties.setProperty("mail.imaps.starttls.enable", "true");
//	    properties.setProperty("ssl.SocketFactory.provider", "my.package.name.ExchangeSSLSocketFactory");
//	    properties.setProperty("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//	   
//	    properties.setProperty("mail.protocol.ssl.trust","10.100.1.103");
	    Session session = Session.getInstance(properties, null);
	    session.setDebug(true);
	    Store store = session.getStore("imap");
	    store.connect("amal.awadallah@jawwal.ps", "bouaz@889");
	}
	
	@Test
	public void fetchMail() throws MessagingException{
		mailf();
	}
}
