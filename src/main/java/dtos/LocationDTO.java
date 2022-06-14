package dtos;

import entities.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationDTO {

    /** This is my variables **/

    private Integer id;
    private String location;
    private List<MatchDTO> matches;



    /** This is the constructor **/

    public LocationDTO(String location) {
        this.location = location;

    }

    public LocationDTO(Location entity) {
        this.id = entity.getId();
        this.location = entity.getLocation();
        //this.players = entity.getPlayers() != null ? entity.getPlayerDTOList(entity.getPlayers()) : new ArrayList<>();
    }

    /** GETTERS AND SETTERS **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    @Override
    public String toString() {
        return "LocationDTO{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", matches='" + matches + '\'' +
                '}';
    }
}
