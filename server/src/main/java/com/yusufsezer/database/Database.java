package com.yusufsezer.database;

import com.yusufsezer.model.Contact;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database {

    private static final Map<Integer, Contact> contacts = new ConcurrentHashMap<>();

    public static Map<Integer, Contact> getContacts() {
        return contacts;
    }

}
