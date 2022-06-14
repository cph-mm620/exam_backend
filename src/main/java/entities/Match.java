package entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "match.deleteAllRows", query = "DELETE from Match m")
@Table(name = "match")
public class Match implements Serializable {
    private static final long serialVersionUID = 1L;

    //Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "apponentTeam", length = 45, nullable = false)
    private String apponentTeam;

    @Column(name = "judge", length = 45, nullable = false)
    private String judge;

    @Column(name = "type", length = 45, nullable = false)
    private String type;

    @Column(name = "inDoors", nullable = false)
    private int inDoors;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Player> playerList = new ArrayList<>();

    @OneToMany
    private List<Location> locations = new ArrayList<>();

    //Constructor

    public Match() {
    }


    public Match(Integer id, String apponentTeam, String judge, String type,  User user) {
        this.id = id;
        this.apponentTeam = apponentTeam;
        this.judge = judge;
        this.type = type;
        this.user = user;
    }

    public Match(String apponentTeam, String judge, String type) {
        this.apponentTeam = apponentTeam;
        this.judge = judge;
        this.type = type;
    }

    public Match(String apponentTeam, String judge, String type,  User user) {
        this.apponentTeam = apponentTeam;
        this.judge = judge;
        this.type = type;
        this.user = user;
    }



    public Match(String apponentTeam, String judge, User user, List<Player> playerList) {
        this.apponentTeam = apponentTeam;
        this.judge = judge;
        this.user = user;
        this.playerList = playerList;
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApponentTeam() {
        return apponentTeam;
    }

    public void setApponentTeam(String apponentTeam) {
        this.apponentTeam = apponentTeam;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInDoors() {
        return inDoors;
    }

    public void setInDoors(int inDoors) {
        this.inDoors = inDoors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Location> getLocations() {
        return locations;
    }

    //Methods

    public void addPlayers (Player player) {
        playerList.add(player);
    }

    public List<String> getPlayerAsStrings() {
        if (playerList.isEmpty()) {
            return null;
        }
        List<String> playerAsStrings = new ArrayList<>();
        playerList.forEach((wa) -> {
            playerAsStrings.add(wa.getName());
        });
        return playerAsStrings;
    }

    public void addLocations (Location location) {
        locations.add(location);
    }

    //toString


    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", apponentTeam='" + apponentTeam + '\'' +
                ", judge=" + judge +
                ", user=" + user +
                '}';
    }
}