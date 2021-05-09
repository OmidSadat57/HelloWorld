package com.example.springboot.service;

public class WunschStadt {

    private final Long id;
    private final String stadtName;
    private String urlaubsWunsch;

    public WunschStadt(Long id, String stadtName, String urlaubsWunsch) {
        this.id = id;
        this.stadtName = stadtName;
        this.urlaubsWunsch = urlaubsWunsch;
    }

    public Long getId() {
        return id;
    }

    public String getStadtName() {
        return stadtName;
    }

    public String getUrlaubsWunsch() {
        return urlaubsWunsch;
    }

    public void setUrlaubsWunsch(String urlaubsWunsch) {
        this.urlaubsWunsch = urlaubsWunsch;
    }

    @Override
    public String toString() {
        return "WunschStadt{" +
                "id=" + id +
                ", stadtName='" + stadtName + '\'' +
                ", urlaubsWunsch='" + urlaubsWunsch + '\'' +
                '}';
    }
}
