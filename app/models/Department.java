package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.NoSuchAlgorithmException;

@Entity
public class Department extends Model {

    //used to simplify querying our model
    public static final Finder<Long, Department> find = new Finder<>(Department.class);

    @Id
    private Long id;

    private String name;
    private String abbreviation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation() {
        this.abbreviation = abbreviation;
    }