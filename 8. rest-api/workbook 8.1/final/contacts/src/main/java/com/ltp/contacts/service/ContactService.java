package com.ltp.contacts.service;

import java.util.List;

import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id) throws NoContactException;
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact) throws NoContactException;
    void deleteContact(String id) throws NoContactException;
    List<Contact> getContacts();
}
