package models;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address extends Model {

    @Id
    private int id;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zip;

    @OneToMany
    private User user;
}
