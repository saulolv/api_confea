package gov.api_confea.specification;

import gov.api_confea.dtos.UsuarioFiltroDto;
import gov.api_confea.model.Usuario;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSpecification {
    public static Specification<Usuario> filtrar(UsuarioFiltroDto filtro) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

//            if (filtro.getLogin() != null) {
//                predicates.add(builder.equal(root.get("cpf"), filtro.getLogin()));
//            }
//            if (filtro.getLogin() != null) {
//                predicates.add(builder.equal(root.get("email"), filtro.getLogin()));
//            }
            predicates.add(builder.or(
                    builder.equal(root.get("cpf"), filtro.getLogin()),
                    builder.equal(root.get("email"), filtro.getLogin())
            ));

            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }
}
