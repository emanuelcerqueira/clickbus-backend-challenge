package io.github.emanuelcerqueira.clickbusbackendchallenge.core.repository;

import io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain.Place;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaceRepository extends PagingAndSortingRepository<Place, UUID>, JpaSpecificationExecutor<Place> {

}
