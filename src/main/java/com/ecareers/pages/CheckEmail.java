package com.ecareers.pages;
import java.io.IOException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import org.apache.commons.lang3.ArrayUtils;

public class CheckEmail {

	public String getPassword() throws MessagingException, IOException{
		Properties prop = new Properties();
		prop.setProperty("mail.imap.auth.login.disable","true");
		prop.setProperty("mail.imap.auth.plain.disable", "true");
		prop.setProperty("mail.imap.auth.ntlm.disable", "false");
		prop.setProperty("mail.imap.auth.xoauth2.disable", "false");
		prop.setProperty("mail.imap.starttls.enable", "true");
	    prop.setProperty("mail.imap.ssl.enable", "true");
	    prop.setProperty("mail.imap.ssl.trust", "10.100.1.103");

		Session session = Session.getDefaultInstance(prop, null);
		Store store = session.getStore("imap");
		store.connect("10.100.1.103","amal.awadallah","bouaz@889");
		Folder inbox = store.getFolder("inbox");
		inbox.open(Folder.READ_ONLY);

	    Flags seen = new Flags(Flags.Flag.SEEN);
	    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
	    Flags recent = new Flags(Flags.Flag.RECENT);
	    FlagTerm recentFlagTerm = new FlagTerm(recent, true);
	    SearchTerm searchTerm = new AndTerm(unseenFlagTerm, recentFlagTerm);
	    Message[] messages = inbox.search(searchTerm);
	    ArrayUtils.reverse(messages);

		for (int i = 0; i <  messages.length; i++) {		  
			Multipart mp = (Multipart) messages[i].getContent();
			BodyPart bp = mp.getBodyPart(i);

			String subject = messages[i].getSubject();
			if(subject.equals("أهلاً وسهلاً بكم في برنامج طلبات التوظيف")){
				String password =  bp.getContent().toString().split("إدارة الموارد البشرية")[0].split("المرور :")[1].trim();
				return password;
			}
      		else if(subject.equals("Welcome to Jawwal ECareer")){
				String password =  bp.getContent().toString().split("إدارة الموارد البشرية")[0].split("Password : ")[1].trim();
				return password;
				}
		}
		String error = ("Verification Email is not sent");
		return error;
	}
}		 