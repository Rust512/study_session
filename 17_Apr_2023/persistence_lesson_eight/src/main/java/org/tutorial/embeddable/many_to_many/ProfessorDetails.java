package org.tutorial.embeddable.many_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tutorial.entity.many_to_many.Professor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProfessorDetails {
    @ManyToMany
    private Set<Professor> professors;
}
