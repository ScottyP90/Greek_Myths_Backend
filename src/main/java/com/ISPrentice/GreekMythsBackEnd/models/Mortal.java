package com.ISPrentice.GreekMythsBackEnd.models;

import com.ISPrentice.GreekMythsBackEnd.Interface.IHumans;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "mortals")
public class Mortal implements IHumans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mortalName")
    private String mortalName;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties("mortals")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "human_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "myth_id", nullable = false, updatable = false)}
    )
    private ArrayList<Myth> myths;

    public Mortal(String mortalName, String shortDescription, String description) {
        this.mortalName = mortalName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.myths = new ArrayList<Myth>();
    }

    public String getMortalName() {
        return mortalName;
    }

    public Mortal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMortalName(String mortalName) {
        this.mortalName = mortalName;
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
