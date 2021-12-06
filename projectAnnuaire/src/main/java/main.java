import java.util.Date;

import com.dao.IDao;
import com.models.Contact;
import com.service.ContactImpIDao;

public class main {

	public static void main(String[] args) {
		IDao con = new ContactImpIDao();
		con.addContact(new Contact("mouad","mouad@gamil.com","93000",new Date(),""));
		
	}

}
