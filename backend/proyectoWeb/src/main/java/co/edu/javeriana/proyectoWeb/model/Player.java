package co.edu.javeriana.proyectoWeb.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Player 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String password;
    String last_updated;

    Long attack_level;
    Long defence_slash;
    Long size;
    Long hitpoints;
    Long maxWeight;
    Long clock;
    Long max_time;
    Long weight;

    @ManyToOne
    Room idRoom;

    @OneToMany(mappedBy = "idPlayer")
    List<Item> items = new ArrayList<>();

    Role role;

    public Player() 
    {

    }

    public Player(String name)
    {
        this.name = name;
    }

    public Player(String name, String password, String last_updated, Long attack_level, Long defence_slash, Long size, Long hitpoints,
            Long maxWeight, Long clock, Long max_time, Room idRoom, List<Item> items, Role role, Long weight) 
    {
        this.name = name;
        this.password = password;
        this.last_updated = last_updated;
        this.role = role;
        this.attack_level = attack_level;
        this.defence_slash = defence_slash;
        this.size = size;
        this.hitpoints = hitpoints;
        this.maxWeight = maxWeight;
        this.clock = clock;
        this.max_time = max_time;
        this.idRoom = idRoom;
        this.items = items;
        this.role = role;
        this.weight = weight;
    }

    public Player(String name, String password, String last_updated, Long attack_level, Long defence_slash, Long size, Long hitpoints,
            Long maxWeight, Long clock, Long max_time, List<Item> items, Role role, Long weight) 
    {
        this.name = name;
        this.password = password;
        this.last_updated = last_updated;
        this.attack_level = attack_level;
        this.defence_slash = defence_slash;
        this.size = size;
        this.hitpoints = hitpoints;
        this.maxWeight = maxWeight;
        this.clock = clock;
        this.max_time = max_time;
        this.items = items;
        this.role = role;
        this.weight = weight;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public Long getWeight() 
    {
        return weight;
    }

    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public String getLast_updated() 
    {
        return last_updated;
    }

    public void setLast_updated(String last_updated) 
    {
        this.last_updated = last_updated;
    }

    public Long getAttack_level()
    {
        return attack_level;
    }

    public void setAttack_level(Long attack_level) 
    {
        this.attack_level = attack_level;
    }

    public Long getDefence_slash() 
    {
        return defence_slash;
    }

    public void setDefence_slash(Long defence_slash) 
    {
        this.defence_slash = defence_slash;
    }

    public Long getSize() 
    {
        return size;
    }

    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getHitpoints() 
    {
        return hitpoints;
    }

    public void setHitpoints(Long hitpoints) 
    {
        this.hitpoints = hitpoints;
    }

    public Long getMaxWeight() 
    {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) 
    {
        this.maxWeight = maxWeight;
    }

    public Long getClock() 
    {
        return clock;
    }

    public void setClock(Long clock) 
    {
        this.clock = clock;
    }

    public Long getMax_time() 
    {
        return max_time;
    }

    public void setMax_time(Long max_time) 
    {
        this.max_time = max_time;
    }

    @JsonManagedReference
    public List<Item> getItems() 
    {
        return items;
    }

    public void setItems(List<Item> items) 
    {
        this.items = items;
    }

    @JsonManagedReference
    public Room getIdRoom() 
    {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) 
    {
        this.idRoom = idRoom;
    }

    public void unlinkRoomPlayer(Room r)
    {
        this.idRoom=null;
        r.setrPlayers(null); 
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public Role getRole() 
    {
        return role;
    }

    public void setRole(Role role) 
    {
        this.role = role;
    }  
}