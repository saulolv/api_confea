package gov.api_confea.specification;

import gov.api_confea.dtos.ProfissionalFiltroDto;
import gov.api_confea.model.Profissional;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class ProfissionalSpecification {
    public static Specification<Profissional> filtrar(ProfissionalFiltroDto filtro) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filtro.getNome() != null) {
                predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
            }
            if (filtro.getRnp() != null) {
                predicates.add(builder.equal(root.get("rnp"), filtro.getRnp()));
            }
            if (filtro.getUfNaturalidade() != null) {
                predicates.add(builder.equal(root.get("ufNaturalidade"), filtro.getUfNaturalidade()));
            }
            if (filtro.getCidadeNaturalidade() != null) {
                predicates.add(builder.equal(root.get("cidadeNaturalidade"), filtro.getCidadeNaturalidade()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}