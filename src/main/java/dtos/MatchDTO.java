package dtos;

import entities.Match;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatchDTO {
    private int id;
    private String apponentTeam;
    private String judge;
    private String type;
    private String inDoors;
    private User user;
    private List<PlayerDTO> players = new ArrayList<>();

    public MatchDTO(String apponentTeam, String judge, String type, String inDoors ) {
        this.apponentTeam = apponentTeam;
        this.judge = judge;
        this.type = type;
        this.inDoors = inDoors;
    }

    public static List<MatchDTO> getDtos(List<Match> m){
        List<MatchDTO> rmdtos = new ArrayList();
        m.forEach(ma->rmdtos.add(new MatchDTO(ma)));
        return rmdtos;
    }

    public MatchDTO(Match m) {
        if(m != null){
            this.id = m.getId();
            this.apponentTeam = m.getApponentTeam();
            this.judge = m.getJudge();
            this.type = m.getType();
            //this.inDoors = m.getInDoors()
            this.players = PlayerDTO.getDtos(m.getPlayerList());
        }
    }

    public List<PlayerDTO> getPlayer() {
        return players;
    }

    public void addPlayer(PlayerDTO players) {
        this.players.add(players);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getInDoors() {
        return inDoors;
    }

    public void setInDoors(String inDoors) {
        this.inDoors = inDoors;
    }

    public List<PlayerDTO> getPlayerDTO() {
        return players;
    }

    public void setPlayerDTOS(List<PlayerDTO> playerDTO) {
        this.players = playerDTO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchDTO that = (MatchDTO) o;
        return id == that.id && apponentTeam.equals(that.apponentTeam) && judge.equals(that.judge) && type.equals(that.type) && inDoors.equals(that.inDoors) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apponentTeam, judge, type, user);
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
                "id=" + id +
                ", apponentTeam'" + apponentTeam + '\'' +
                ", judge='" + judge + '\'' +
                ", type='" + type + '\'' +
                ", inDoors='" + inDoors + '\'' +
                ", user=" + user +
                '}';
    }
}
