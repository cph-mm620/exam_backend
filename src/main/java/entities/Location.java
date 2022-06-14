package entities;

import dtos.PlayerDTO;
import dtos.LocationDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "location.deleteAllRows", query = "DELETE from Location l")
@Table(name = "location")

public class Location implements Serializable {

    /**
     * This is my variables
     **/
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location", length = 45, nullable = false)
    private String location;

    @Column(name = "adresse", length = 45, nullable = false)
    private String adresse;

    @Column(name = "city", length = 45, nullable = false)
    private String city;

    @Column(name = "condition", length = 45, nullable = false)
    private String condition;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id", referencedColumnName = "id", nullable = false)
    private Match matches;


    /**
     * This is my constructor
     **/

    public Location() {
    }

    public Location(Integer id, String adresse, String city) {
        this.id = id;
        this.adresse = adresse;
        this.city = city;
        //this.players = new ArrayList<>();
    }

    public Location(Integer id, String city, List<Player> players) {
        this.id = id;
        this.city = city;
       // this.players = players;
    }

    // TODO: MAKE DTOS
//    public location(zoodto dto) {
//        this.id = dto.getid();
//        this.zoo = dto.getzoo();
//        this.animals = dto.getanimals() != null ? getanimallist(dto.getanimals()) : new arraylist<>();
//    }

    /**
     * GETTERS AND SETTERS
     **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


    /**
     * This is where all my methods go
     **/


  /*  public void replacePlayer(ArrayList<Player> players) {
        this.players = players;
    }*/

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", matches=" + matches +
                '}';
    }
}