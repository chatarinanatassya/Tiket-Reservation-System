package com.example.mytee.model;

public class EventData {
    String eventname;
    String country;
    String price;
    Integer Imagetour;

    public String getEventname() {
        return eventname;
    }

    public String getCountry() {
        return country;
    }

    public String getPrice() {
        return price;
    }

    public Integer getImagetour() {
        return Imagetour;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImagetour(Integer imagetour) {
        Imagetour = imagetour;
    }

    public EventData(String eventname, String country, String price, Integer Imagetour) {
        this.eventname = eventname;
        this.country = country;
        this.price = price;
        this.Imagetour = Imagetour;
    }


}
