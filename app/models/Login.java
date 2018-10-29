package models;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Login extends Model {

    @Id
    private String email;
    private String password;
   
}
