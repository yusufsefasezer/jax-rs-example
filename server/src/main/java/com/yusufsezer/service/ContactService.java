package com.yusufsezer.service;

import com.yusufsezer.database.Database;
import com.yusufsezer.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Path;

@Path("/contact-service")
public class ContactService {

    private static final Map<Integer, Contact> contacts = Database.getContacts();

    static {
        contacts.put(1, new Contact(1, "Rhody Farquhar", "rfarquhar0@va.gov", "2906036054", "http://prweb.com", "https://robohash.org/illumetrerum.png?size=100x100&set=set1", "032 Waubesa Avenue", "vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id"));
        contacts.put(2, new Contact(2, "Farand Valde", "fvalde1@reference.com", "7504488204", "https://uol.com.br", "https://robohash.org/voluptatemsimiliqueculpa.png?size=100x100&set=set1", "7 Paget Crossing", "eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus"));
        contacts.put(3, new Contact(3, "Sarene Cowdery", "scowdery2@behance.net", "2518926895", "https://multiply.com", "https://robohash.org/illoetsint.png?size=100x100&set=set1", "52256 North Circle", "turpis enim blandit mi in porttitor pede justo eu massa donec"));
        contacts.put(4, new Contact(4, "Tasia Oldridge", "toldridge3@unc.edu", "2552926925", "http://icio.us", "https://robohash.org/eumquamexplicabo.png?size=100x100&set=set1", "11 Merrick Point", "congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum"));
        contacts.put(5, new Contact(5, "Raina Pigney", "rpigney4@weibo.com", "1665350879", "https://imdb.com", "https://robohash.org/ametquodiusto.png?size=100x100&set=set1", "50 Petterle Hill", "interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien"));
        contacts.put(6, new Contact(6, "Rhianna Dermot", "rdermot5@answers.com", "1657592814", "https://clickbank.net", "https://robohash.org/iustoexcepturiquia.png?size=100x100&set=set1", "6565 Sherman Trail", "lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet"));
        contacts.put(7, new Contact(7, "Eduard Oakden", "eoakden6@cpanel.net", "9512879955", "https://army.mil", "https://robohash.org/ducimuslaboriosamqui.png?size=100x100&set=set1", "9 2nd Road", "venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at"));
        contacts.put(8, new Contact(8, "Gaby Berndtssen", "gberndtssen7@hubpages.com", "3003138365", "http://quantcast.com", "https://robohash.org/eteosblanditiis.png?size=100x100&set=set1", "2925 Aberg Circle", "magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus"));
        contacts.put(9, new Contact(9, "Gill Hunnable", "ghunnable8@dot.gov", "7078567528", "http://boston.com", "https://robohash.org/quovoluptatemvoluptas.png?size=100x100&set=set1", "03 Johnson Terrace", "mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse"));
        contacts.put(10, new Contact(10, "Bethanne Agius", "bagius9@oakley.com", "5969400750", "http://google.it", "https://robohash.org/harumvelitaut.png?size=100x100&set=set1", "8 American Drive", "vestibulum vestibulum ante ipsum primis in faucibus orci luctus et"));
    }

    public ContactService() {
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    public Contact addContact(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.put(contact.getId(), contact);
        return contact;
    }

    public Contact updateContact(int id, Contact contact) {
        contacts.put(id, contact);
        return contact;
    }

    public Contact removeContact(int id) {
        return contacts.remove(id);
    }

}
