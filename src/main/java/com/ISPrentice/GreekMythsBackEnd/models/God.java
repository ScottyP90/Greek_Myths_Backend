package com.ISPrentice.GreekMythsBackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gods")
public class God implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "godName")
    private String godName;

    @Column(name = "title")
    private String title;

    @Column(name = "domain")
    private String domain;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties("gods")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "gods_myths",
            joinColumns = {@JoinColumn(name = "god_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "myth_id", nullable = false, updatable = false)}
    )
    private List<Myth> myths;

    public God(String godName, String title, String domain, String shortDescription, String description) {
        this.godName = godName;
        this.title = title;
        this.domain = domain;
        this.shortDescription = shortDescription;
        this.description = description;
        this.myths = new ArrayList<Myth>();
    }

    public God() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public List<Myth> getMyths() {
        return myths;
    }

    public void setMyths(List<Myth> myths) {
        this.myths = myths;
    }

    public void addMyth(Myth myth){
        this.myths.add(myth);
    }
}
