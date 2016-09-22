
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;

import org.testng.annotations.Test;
public class CheckEmail {
    /**
* Searches for e-mail messages containing the specified keyword in
* Subject field.
* @param host
* @param port
* @param userName
* @param password
* @param keyword
* @throws IOException
*/
@SuppressWarnings("unused")
private boolean textIsHtml = false;
    /**
* Return the primary text content of the message.
*/
    private String getText(Part p) throws MessagingException,IOException {
        if (p.isMimeType("text/*")) {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }
    public boolean searchEmail(String userName,String password, final String subjectKeyword, final String fromEmail, final String bodySearchText) throws IOException {
        
        boolean val = false;
		Properties prop = new Properties();
		prop.setProperty("mail.imap.auth.login.disable","true");
		prop.setProperty("mail.imap.auth.plain.disable", "true");
		prop.setProperty("mail.imap.auth.ntlm.disable", "false");
		prop.setProperty("mail.imap.auth.xoauth2.disable", "false");
		prop.setProperty("mail.imap.starttls.enable", "true");

	    prop.setProperty("mail.imap.ssl.enable", "true");
	    prop.setProperty("mail.imap.ssl.trust", "10.100.1.103");

        Session session = Session.getDefaultInstance(prop);
        try {
        //	session.setDebug(true);
            // connects to the message store
            Store store = session.getStore("imap");
            store.connect("10.100.1.103","amal.awadallah","bouaz@889");
            System.out.println("Connected to Email server….");
            // opens the inbox folder
            Folder folderInbox = store.getFolder("inbox");
            folderInbox.open(Folder.READ_ONLY);
            //create a search term for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
         
            // performs search through the folder
            Message[] foundMessages = folderInbox.search(unseenFlagTerm);
            System.out.println("Total Messages Found :"+foundMessages.length);
            for (int i=foundMessages.length-1 ; i>=foundMessages.length-10;i--) {
                    Message message = foundMessages[i];
                    Address[] froms = message.getFrom();
                    System.out.println(foundMessages[i].getContentType());
                  
				
					try {
					if(message.getSubject().contains("Welcome")){
					String subject = message.getSubject();
					// System.out.println(getText(message));
					System.out.println("Found message #" + i + ": ");
					System.out.println("At "+ i + " :"+ "Subject:"+ subject);
					System.out.println("From:  : "+message.getReceivedDate());
					Multipart mp = (Multipart) foundMessages[i].getContent();
					BodyPart bp = mp.getBodyPart(i);


					if(getText(message).contains(bodySearchText)== true){
					System.out.println("Message contains the search text "+bodySearchText);
					String password1 = getText(message).split("إدارة الموارد البشرية")[0].split("Password :")[0];
					System.out.println("daskjafhahfahfasjf3289999999        " + password1);
					
					val=true;
					}
					else{
					val=false;
					}
					break;
					}
					} catch (NullPointerException expected) {
					// TODO Auto-generated catch block
					expected.printStackTrace();
					}
					System.out.println("Searching.…" +"At "+ i );
					            }
					            // disconnect
					            folderInbox.close(false);
					            store.close();
					        } catch (NoSuchProviderException ex) {
					            System.out.println("No provider.");
					            ex.printStackTrace();
					        } catch (MessagingException ex) {
					            System.out.println("Could not connect to the message store.");
					            ex.printStackTrace();
					        }
					return val;
					    }
    /**
* Test this program with a Gmail’s account
* @throws IOException
*/
 
    @Test
    public void testmail() throws IOException{
    	 String userName = "amal.awadallah";
         String password = "bouaz@889";
         CheckEmail searcher = new CheckEmail();
         String subjectKeyword = "Welcome to Jawwal ECareer";
         String fromEmail="eCareer@jawwal.ps";
         String bodySearchText ="إدارة الموارد البشرية";
         searcher.searchEmail(userName, password,subjectKeyword,fromEmail, bodySearchText);
    }
}

 
