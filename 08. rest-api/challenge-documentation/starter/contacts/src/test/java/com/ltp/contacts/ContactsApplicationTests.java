package com.ltp.contacts;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
class ContactsApplicationTests {

	@Autowired
	ContactRepository contactRepository;

	private Contact[] contacts = new Contact[] {
		new Contact("1", "Jon Snow", "6135342524"),
		new Contact("2", "Tyrion Lannister", "4145433332"),
		new Contact("3", "The Hound", "3452125631"),
	};

	@BeforeEach
    void setup(){
		for (int i = 0; i < contacts.length; i++) {
			contactRepository.saveContact(contacts[i]);
		}
    }

	@AfterEach
	void clear(){
		contactRepository.getContacts().clear();
    }


	@Test
	public void getContactByIdTest() throws Exception {

	}
	
	@Test
	public void getAllContactsTest() throws Exception {

	}

	@Test
	public void validContactCreation() throws Exception {

	}

	@Test
	public void invalidContactCreation() throws Exception {

	}

	@Test
	public void contactNotFoundTest() throws Exception {

	}



}



