

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.testng.annotations.Test;

public class gmail {

	public void checkmail(){
	 Properties props = new Properties();
     props.setProperty("mail.store.protocol", "imap");
     props.put( "mail.imap.sasl.enable", "true" );
     props.put("mail.imap.ssl.socketFactory", "javax.net.ssl.SSLSocketFactory");
     props.setProperty("mail.imap.ssl.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
     props.setProperty("mail.imap.starttls.enable", "true");
     props.setProperty("mail.imap.starttls.required", "true");
     props.setProperty("mail.imap.socketFactory.fallback", "false" );

     try {
         Session session = Session.getInstance(props, null);
         Store store = session.getStore();
         store.connect("imap.gmail.com", "amel.awadallah@gmail.com", "0568560410");
         Folder inbox = store.getFolder("INBOX");
         inbox.open(Folder.READ_ONLY);
         Message msg = inbox.getMessage(inbox.getMessageCount());
         Address[] in = msg.getFrom();
         for (Address address : in) {
             System.out.println("FROM:" + address.toString());
         }
         Multipart mp = (Multipart) msg.getContent();
         BodyPart bp = mp.getBodyPart(0);
         System.out.println("SENT DATE:" + msg.getSentDate());
         System.out.println("SUBJECT:" + msg.getSubject());
         System.out.println("CONTENT:" + bp.getContent());
     } catch (Exception mex) {
         mex.printStackTrace();
     }
 }
   

   @Test
   public  void testrem() {

    

      checkmail();

   }

}