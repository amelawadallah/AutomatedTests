import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.mail.search.SubjectTerm;

import org.testng.annotations.Test;

public class smtpexample {

	public  void sendMail() throws Exception {
//		public static void main(String[] args) throws Exception {
	        Properties props = System.getProperties();
	        props.setProperty("mail.store.protocol", "imap");
	        props.setProperty("mail.imap.ssl.enable", "true");
	    	props.setProperty("mail.imap.auth.login.disable","true");
			props.setProperty("mail.imap.auth.plain.disable", "true");
			props.setProperty("mail.imap.auth.ntlm.disable", "false");
			props.setProperty("mail.imap.auth.xoauth2.disable", "false");
			props.setProperty("mail.imap.starttls.enable", "true");
		    props.setProperty("mail.imap.ssl.enable", "true");
		    props.setProperty("mail.imap.ssl.trust", "10.100.1.103");


	            Session session = Session.getDefaultInstance(props, null);
	        	Store store = session.getStore("imap");
	    		store.connect("10.100.1.103","amal.awadallah","bouaz@889");

	            Folder folder = store.getFolder("INBOX");
	            folder.open(Folder.READ_WRITE);

	            System.out.println("Total Message:" + folder.getMessageCount());
	            System.out.println("Unread Message:"
	                    + folder.getUnreadMessageCount());
	            
	            Message[] messages = null;
	            boolean isMailFound = false;
	            Message mailFromGod= null;

	            //Search for mail from God
	            for (int i = 0; i < 5; i++) {
	                messages = folder.search(new SubjectTerm(
	                        "أهلاً وسهلاً بكم في برنامج طلبات التوظيف"),
	                        folder.getMessages());
	                //Wait for 10 seconds
	                if (messages.length == 0) {
	                    Thread.sleep(10000);
	                }
	            }

	            //Search for unread mail from God
	            //This is to avoid using the mail for which 
	            //Registration is already done
	            for (Message mail : messages) {
//	                if (!mail.isSet(Flags.Flag.SEEN)) {
//	                    mailFromGod = mail;
//	                    System.out.println("Message Count is: "
//	                            + mailFromGod.getMessageNumber());
//	                    isMailFound = true;
//	                }
//	            }

	            //Test fails if no unread mail was found from God
//	            if (!isMailFound) {
//	                throw new Exception(
//	                        "Could not find new mail from God :-(");
//	            
//	            //Read the content of mail and launch registration URL                
//	            } else {
	            	 Folder inbox = store.getFolder("inbox");
	        		 inbox.open(Folder.READ_ONLY);
	        		 int messageCount = inbox.getMessageCount();   
	            
	   		 Flags seen = new Flags(Flags.Flag.SEEN);
			 FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
			 Message messages2[] = inbox.search(unseenFlagTerm);
	                String line;
	                StringBuffer buffer = new StringBuffer();
	                BufferedReader reader = new BufferedReader(
	                        new InputStreamReader(mailFromGod
	                                .getInputStream()));
	                while ((line = reader.readLine()) != null) {
	                    buffer.append(line);
	                }
	                System.out.println(buffer);

	                //Your logic to split the message and get the Registration URL goes here
	                String registrationURL = buffer.toString().split("&amp;gt;http://www.god.de/members/?")[0]
	                        .split("href=")[1];
	                System.out.println(registrationURL);                            
	            }
	}
	
	@Test
	public void testSendEmail() throws Exception{
		sendMail();
	}
}
