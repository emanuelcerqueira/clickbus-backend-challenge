package io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Place extends BaseEntity {

    private String name;
    private String slug;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;

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
