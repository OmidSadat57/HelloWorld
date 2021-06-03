package com.example.springboot.persistence;


import javax.persistence.*;

@Entity
@Table(name = "wunschstadt")
public class WunschStadtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadt_id", nullable = false)
    private Long stadtId;

    @Column(name = "stadt_name", nullable = false)
    private String stadtName;

    @Column(name = "ulaubswunsch")
    private String urlaubsWunsch;

    @Column(name = "owner")
    private String owner;

    public WunschStadtEntity() { }

    public WunschStadtEntity(String stadtName, String urlaubsWunsch) {
        this.stadtName = stadtName;
        this.urlaubsWunsch = urlaubsWunsch;
    }

    public WunschStadtEntity(String stadtName, String urlaubsWunsch, String owner) {
        this.stadtName = stadtName;
        this.urlaubsWunsch = urlaubsWunsch;
        this.owner = owner;
    }

    public Long getStadtId() {
        return stadtId;
    }

    public void setStadtId(Long stadtId) {
        this.stadtId = stadtId;
    }

    public String getStadtName() {
        return stadtName;
    }

    public void setStadtName(String stadtName) {
        this.stadtName = stadtName;
    }

    public String getUrlaubsWunsch() {
        return urlaubsWunsch;
    }

    public void setUrlaubsWunsch(String urlaubsWunsch) {
        this.urlaubsWunsch = urlaubsWunsch;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
