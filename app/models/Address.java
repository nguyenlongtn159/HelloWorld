package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import play.db.ebean.Model;

/**
 * Created by nguyenlongtn159 on 3/10/2015.
 */
@Entity
public class Address extends Model{
    @Id
    public Long id;

    @OneToOne(mappedBy = "address")
    public Warehouse warehouse;

    public String street;
    public String number;
    public String postalCode;
    public String city;
    public String country;
}