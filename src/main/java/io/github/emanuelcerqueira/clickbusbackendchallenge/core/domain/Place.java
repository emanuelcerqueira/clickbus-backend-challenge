package io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain;

import io.github.emanuelcerqueira.clickbusbackendchallenge.sharedKernel.Audit;
import io.github.emanuelcerqueira.clickbusbackendchallenge.sharedKernel.BaseEntity;

import javax.persistence.*;

@Entity
public class Place extends BaseEntity {

    private String name;
    @Column(unique = true)
    private String slug;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;

    @Embedded
    private Audit audit = new Audit();

    @Deprecated
    public Place() {
    }

    public Place(String name, String slug, String city, State state) {
        this.name = name;
        this.slug = slug;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(State state) {
        this.state = state;
    }

}
