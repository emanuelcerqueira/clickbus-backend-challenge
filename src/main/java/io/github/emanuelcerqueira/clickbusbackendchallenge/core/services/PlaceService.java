package io.github.emanuelcerqueira.clickbusbackendchallenge.core.services;

import io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain.Place;
import io.github.emanuelcerqueira.clickbusbackendchallenge.core.services.exception.ObjectNotFoundException;
import io.github.emanuelcerqueira.clickbusbackendchallenge.core.repository.PlaceRepository;
import io.github.emanuelcerqueira.clickbusbackendchallenge.core.repository.specification.PlaceSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place create(Place place) {
        return placeRepository.save(place);
    }

    public Place update(Place place, UUID id) {
        return placeRepository.findById(id)
            .map(record -> {
                record.setName(place.getName());
                record.setCity(place.getCity());
                record.setSlug(place.getSlug());
                record.setState(place.getState());

               return placeRepository.save(record);
            }).orElseThrow(() -> new ObjectNotFoundException("The place does not exist."));
    }

    public void deleteById(UUID id) {
        placeRepository.deleteById(id);
    }

    public Place findById(UUID id) {
        return placeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("The place does not exist."));
    }

    public Page<Place> findAll(Integer page, Integer linesPerPage, String orderBy, String direction, PlaceSpecification placeSpecification) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return placeRepository.findAll(placeSpecification, pageRequest);
    }

}
