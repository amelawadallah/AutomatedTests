//import java.io.IOException;
//import java.util.Date;
//import java.util.Properties;
//import javax.mail.Address;
//import javax.mail.Flags;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Part;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.internet.InternetAddress;
//import javax.mail.search.FlagTerm;
//import javax.mail.search.OrTerm;
//import javax.mail.search.SearchTerm;
//public class mailtest {
//    /**
//* Searches for e-mail messages containing the specified keyword in
//* Subject field.
//* @param host
//* @param port
//* @param userName
//* @param password
//* @param keyword
//* @throws IOException
//*/
//@SuppressWarnings(“unused”)
//private boolean textIsHtml = false;
//    /**
//* Return the primary text content of the message.
//*/
////    private String getText(Part p) throws MessagingException,IOException {
////        if (p.isMimeType(“text/*”)) {
//            String s = (String)p.getContent();
////            textIsHtml = p.isMimeType(“text/html”);
////            return s;
////        }
////        if (p.isMimeType(“multipart/alternative”)) {
////            // prefer html text over plain text
////            Multipart mp = (Multipart)p.getContent();
////            String text = null;
////            for (int i = 0; i < mp.getCount(); i++) {
////                Part bp = mp.getBodyPart(i);
////                if (bp.isMimeType(“text/plain”)) {
////                    if (text == null)
////                        text = getText(bp);
////                    continue;
////                } else if (bp.isMimeType(“text/html”)) {
////                    String s = getText(bp);
////                    if (s != null)
////                        return s;
////                } else {
////                    return getText(bp);
////                }
////            }
////            return text;
////        } else if (p.isMimeType(“multipart/*”)) {
//            Multipart mp = (Multipart)p.getContent();
//            for (int i = 0; i < mp.getCount(); i++) {
//                String s = getText(mp.getBodyPart(i));
//                if (s != null)
//                    return s;
//            }
//        }
//        return null;
//    }
//    public boolean searchEmail(String userName,String password, finalString subjectKeyword, final String fromEmail, final StringbodySearchText) throws IOException {
//        Properties properties = new Properties();
//        boolean val = false;
//        // server setting
//        properties.put(“mail.imap.host”, “imap.gmail.com“);
//        properties.put(“mail.imap.port”, 993);
//        // SSL setting
//        properties.setProperty(“mail.imap.socketFactory.class”,”javax.net.ssl.SSLSocketFactory”);
//        properties.setProperty(“mail.imap.socketFactory.fallback”, “false”);
//        properties.setProperty(“mail.imap.socketFactory.port”,String.valueOf(993));
//        Session session = Session.getDefaultInstance(properties);
//        try {
//            // connects to the message store
//            Store store = session.getStore(“imap”);
//            store.connect(userName, password);
//            System.out.println(“Connected to Email server….”);
//            // opens the inbox folder
//            Folder folderInbox = store.getFolder(“INBOX”);
//            folderInbox.open(Folder.READ_ONLY);
//            //create a search term for all “unseen” messages
//            Flags seen = new Flags(Flags.Flag.SEEN);
//            FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
//            //create a search term for all recent messages
//            Flags recent = new Flags(Flags.Flag.RECENT);
//            FlagTerm recentFlagTerm = new FlagTerm(recent, false);
//            SearchTerm searchTerm = new OrTerm(unseenFlagTerm,recentFlagTerm);
//            // performs search through the folder
//            Message[] foundMessages = folderInbox.search(searchTerm);
//            System.out.println(“Total Messages Found :”+foundMessages.length);
//            for (int i=foundMessages.length-1 ; i>=foundMessages.length-10;i–) {
//                    Message message = foundMessages[i];
//                    Address[] froms = message.getFrom();
//String email = froms == null ? null : ((InternetAddress)froms[0]).getAddress();
//if(message.getSubject()==null){
//continue;
//}
//Date date = new Date();//Getting Present date from the system
//long diff = date.getTime()-message.getReceivedDate().getTime();//Get The difference between two dates
//long diffMinutes = diff / (60 * 1000) % 60; //Fetching the difference of minute
//// if(diffMinutes>2){
//// diffMinutes=2;
//// }
//System.out.println(“Difference in Minutes b/w present time & Email Recieved time :” +diffMinutes);
//try {
//if(message.getSubject().contains(subjectKeyword) &&email.equals(fromEmail) && getText(message).contains(bodySearchText) && diffMinutes<=3){
//String subject = message.getSubject();
//// System.out.println(getText(message));
//System.out.println(“Found message #” + i + “: “);
//System.out.println(“At “+ i + ” :”+ “Subject:”+ subject);
//System.out.println(“From: “+ email +” on : “+message.getReceivedDate());
//if(getText(message).contains(bodySearchText)== true){
//System.out.println(“Message contains the search text “+bodySearchText);
//val=true;
//}
//else{
//val=false;
//}
//break;
//}
//} catch (NullPointerException expected) {
//// TODO Auto-generated catch block
//expected.printStackTrace();
//}
//System.out.println(“Searching.…” +”At “+ i );
//            }
//            // disconnect
//            folderInbox.close(false);
//            store.close();
//        } catch (NoSuchProviderException ex) {
//            System.out.println(“No provider.”);
//            ex.printStackTrace();
//        } catch (MessagingException ex) {
//            System.out.println(“Could not connect to the message store.”);
//            ex.printStackTrace();
//        }
//return val;
//    }
//    /**
//* Test this program with a Gmail’s account
//* @throws IOException
//*/
//        		
//        	t
//    public void justemail() throws IOException {
//        String userName = "";
//        String password ="";
//        mailtest searcher = new mailtest();
//        String subjectKeyword = "";
//        String fromEmail="";
//        String bodySearchText ="";
//        searcher.searchEmail(userName, password,subjectKeyword,fromEmail, bodySearchText);
//    }
//}