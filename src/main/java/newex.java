import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.xpath.axes.ReverseAxesWalker;
import org.testng.annotations.Test;



public class newex {

	
	public void maillist() throws MessagingException, IOException{
		Properties prop = new Properties();
		prop.setProperty("mail.imap.auth.login.disable","true");
		prop.setProperty("mail.imap.auth.plain.disable", "true");
		prop.setProperty("mail.imap.auth.ntlm.disable", "false");
		prop.setProperty("mail.imap.auth.xoauth2.disable", "false");
		prop.setProperty("mail.imap.starttls.enable", "true");

	    prop.setProperty("mail.imap.ssl.enable", "true");
	    prop.setProperty("mail.imap.ssl.trust", "10.100.1.103");

//		prop.put("ssl.SocketFactory.provider",ExchangeSSLSocketFactory.class);
//		prop.put("mail.imap.socketFactory.class", ExchangeSSLSocketFactory.class);
//		props.put("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(prop, null);
//		session.setDebug(true);
		Store store = session.getStore("imap");
		store.connect("10.100.1.103","amal.awadallah","bouaz@889");
		
		 Folder inbox = store.getFolder("inbox");
		 inbox.open(Folder.READ_ONLY);
//		 int messageCount = inbox.getMessageCount();

		// search for all "unseen" messages
		 Flags seen = new Flags(Flags.Flag.SEEN);
		 FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		 Message messages[] = inbox.search(unseenFlagTerm);
		 
		 for (int x=0 ; x<messages.length; x++){
			 System.out.println("Messgaes is " + messages[x]);
			 System.out.println(messages[x].getContentType());

		 
			 
			 
		 System.out.println(messages.length);
		
		 
		 

		 System.out.println("------------------------------");
		 for (int i = 0; i <=  10; i++) {		  
			 System.out.println(i);
				Multipart mp = (Multipart) messages[i].getContent();
				BodyPart bp = mp.getBodyPart(i);

				String subject = messages[i].getSubject();
				System.out.println("subject is..........."  +  subject);
				if(subject.equals("أهلاً وسهلاً بكم في برنامج طلبات التوظيف")){
					String password =  bp.getContent().toString().split("إدارة الموارد البشرية")[0].split("المرور :")[1];
					System.out.println("Password............" + password );}
        
				else if(subject.equals("Welcome to Jawwal ECareer")){
					String password =  bp.getContent().toString().split("إدارة الموارد البشرية")[0].split("Password : ")[1];
					System.out.println("Password............" + password );
				}
				else{
					System.out.println("Verification Email is not sent");
				}
		 }
		 }
		 }
		  
	
	@Test
	public void newtests() throws MessagingException, IOException{
		maillist();
	}
}
