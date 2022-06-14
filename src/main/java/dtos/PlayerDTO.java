package dtos;

import entities.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String status;


    public PlayerDTO() {
    }

    public PlayerDTO(String name, String status) {
        this.name = name;
        this.status = status;

    }

    public PlayerDTO(String name, String phone, String status) {
        this.name = name;
        this.phone = phone;
        this.status = status;

    }

    public PlayerDTO(Player pl) {
        this.id = pl.getId();
        this.name = pl.getName();
        this.phone = pl.getPhone();
    }

    public static List<PlayerDTO> getDtos(List<Player> p){
        List<PlayerDTO> rmdtos = new ArrayList();
        p.forEach(pl->rmdtos.add(new PlayerDTO(pl)));
        return rmdtos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


    public class PlayersDTO {

        private List<PlayerDTO> allPlayers = new ArrayList<>();


        public PlayersDTO(List<Player> playerList) {
            playerList.forEach((pList) -> {
                allPlayers.add(new PlayerDTO(pList));
            });
        }

        public List<PlayerDTO> getAllPlayers() {
            return allPlayers;
        }

        @Override
        public String toString() {
            return "PlayersDTO{" +
                    "all=" + allPlayers +
                    '}';
        }
    }
    }


