package com.example.mytee.model;

public class OntourData {

    Integer Imagetour;



    public Integer getImagetour() {
        return Imagetour;
    }

    public void setImagetour(Integer imagetour) {
        Imagetour = imagetour;
    }

    public OntourData(String eventname, String country, String price, Integer Imagetour) {

        this.Imagetour = Imagetour;
    }


}
