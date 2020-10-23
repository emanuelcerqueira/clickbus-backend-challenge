package io.github.emanuelcerqueira.clickbusbackendchallenge.web.api;

import io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain.Place;
import io.github.emanuelcerqueira.clickbusbackendchallenge.core.repository.specification.PlaceSpecification;
import io.github.emanuelcerqueira.clickbusbackendchallenge.core.services.PlaceService;
import io.github.emanuelcerqueira.clickbusbackendchallenge.web.api.models.PlaceRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Place> create(@Valid @RequestBody PlaceRequest placeRequest) {
        Place createdPlace = placeService.create(placeRequest.toPlace());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdPlace.getId()).toUri();
        return ResponseEntity.created(uri).body(createdPlace);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Place> update(@Valid @RequestBody PlaceRequest placeRequest, @PathVariable String id) {
        Place updatedPlace = placeService.update(placeRequest.toPlace(), UUID.fromString(id));
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        placeService.deleteById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Place> findById(@PathVariable String id) {
        Place place = placeService.findById(UUID.fromString(id));
        return ResponseEntity.ok(place);
    }

    @GetMapping
    public ResponseEntity<Page<Place>> findAll(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="name") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction,
            @RequestParam(value="name", defaultValue="") String name) {
        Page<Place> places = placeService.findAll(page, linesPerPage, orderBy, direction, new PlaceSpecification(name));
        return ResponseEntity.ok(places);
    }

}
