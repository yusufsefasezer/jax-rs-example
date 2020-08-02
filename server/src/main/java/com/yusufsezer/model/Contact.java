package com.yusufsezer.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {

    private int Id;
    private String Name;
    private String Email;
    private String Phone;
    private String url;
    private String Photo;
    private String Address;
    private String Notes;

    public Contact() {
    }

    public Contact(int Id,
            String Name,
            String Email,
            String Phone,
            String url,
            String Photo,
            String Address,
            String Notes) {
        this.Id = Id;
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.url = url;
        this.Photo = Photo;
        this.Address = Address;
        this.Notes = Notes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

}
