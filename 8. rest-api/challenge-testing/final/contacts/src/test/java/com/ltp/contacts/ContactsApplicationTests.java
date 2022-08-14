package com.ltp.contacts;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
@AutoConfigureMockMvc
class ContactsApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;   

	@Autowired
    private MockMvc mockMvc;

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
		RequestBuilder request = MockMvcRequestBuilders.get("/contact/1");
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name").value(contacts[0].getName()))
			.andExpect(jsonPath("$.phoneNumber").value(contacts[0].getPhoneNumber()));
	}
	
	@Test
	public void getAllContactsTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/contact/all");
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.size()").value(contacts.length))
			.andExpect(jsonPath("$.[?(@.id == \"2\" && @.name == \"Tyrion Lannister\" && @.phoneNumber == \"4145433332\")]").exists());
	}

	@Test
	public void validContactCreation() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/contact")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(new Contact("Rayan Slim", "123456789")));

		mockMvc.perform(request).andExpect(status().isCreated());
	}

	@Test
	public void invalidContactCreation() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/contact")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(new Contact("    ", "    ")));

		mockMvc.perform(request).andExpect(status().isBadRequest());
	}

	@Test
	public void contactNotFoundTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/contact/4");
		mockMvc.perform(request).andExpect(status().isNotFound());
	}



}



