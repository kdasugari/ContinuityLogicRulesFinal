package functionLib;

import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonFunctions {
	public WebDriver driver;
	
	public CommonFunctions(WebDriver driver)
	{
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	}
	public static boolean emailValidation(String subject) throws Exception{
	Properties props = System.getProperties();
    props.setProperty("mail.store.protocol", "imaps");
    Session session = Session.getDefaultInstance(props, null);
    Store store = session.getStore("imaps");
    store.connect("imap.gmail.com", "automationcontinuity@gmail.com","Cl@12345");
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);
        System.out.println("Total Message:" + folder.getMessageCount());
        System.out.println("Unread Message:" + folder.getUnreadMessageCount());
        
        Message[] messages = null;
        boolean isMailFound = false;

        //Search for mail from CL
        for (int i = 0; i < folder.getUnreadMessageCount(); i++) {
            messages = folder.search(new SubjectTerm(subject), folder.getMessages());
            //Wait for 10 seconds
            if (messages.length == 0) {
                isMailFound = false;
                Thread.sleep(10000);
            }else{
                isMailFound = true;
                folder.setFlags(messages, new Flags(Flags.Flag.SEEN), true);
            }
        }       
        return isMailFound;
	}	
}