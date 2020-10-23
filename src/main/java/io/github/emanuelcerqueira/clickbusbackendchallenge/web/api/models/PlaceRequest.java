package io.github.emanuelcerqueira.clickbusbackendchallenge.web.api.models;

import io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain.Place;
import io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain.State;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class PlaceRequest {

    @NotEmpty(message = "Must not be empty.")
    @Length(min=3, max=50, message="The name length must be between 5 and 50 characters.")
    private String name;
    @NotEmpty(message = "Must not be empty.")
    @Length(min=3, max=30, message="The name length must be between 5 and 30 characters.")
    private String slug;
    @NotEmpty(message = "Must not be empty.")
    @Length(min=3, max=50, message="The city length must be between 5 and 50 characters.")
    private String city;
    @NotEmpty(message = "Must not be empty.")
    @Pattern(regexp = "(AC|AL|AM|AP|BA|CE|DF|ES|GO|MA|MG|MS|MT|PA|PB|PE|PI|PR|RJ|RN|RO|RR|RS|SC|SE|SP|TO)")
    private String state;

    public PlaceRequest() {
    }

    public Place toPlace() {
        return new Place(name, slug, city, State.valueOf(state));
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

    public String getState() {
        return state;
    }
}
