package io.github.emanuelcerqueira.clickbusbackendchallenge.core.repository.specification;

import io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain.Place;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceSpecification implements Specification<Place> {

    private final String name;

    public PlaceSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<Place> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(name)) {
            Path<String> nameField = root.get("name");
            Expression<String> nameFieldUpper = builder.upper(nameField);
            Predicate predicateName = builder.like(nameFieldUpper, "%"+name.toUpperCase()+"%");
            predicates.add(predicateName);
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
