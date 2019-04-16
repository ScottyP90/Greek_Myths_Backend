package com.ISPrentice.GreekMythsBackEnd.models;

import com.ISPrentice.GreekMythsBackEnd.Interface.IHumans;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "heroes")
public class Hero implements IHumans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "heroName")
    private String heroName;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties("heroes")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "human_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "myth_id", nullable = false, updatable = false)}
    )
    private ArrayList<Myth> myths;

    public Hero(String heroName, String shortDescription, String description) {
        this.heroName = heroName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.myths = new ArrayList<Myth>();
    }

    public Hero() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Myth> getMyths() {
        return myths;
    }

    public void setMyths(ArrayList<Myth> myths) {
        this.myths = myths;
    }

    public void addMyth(Myth myth){
        this.myths.add(myth);
    }
}
