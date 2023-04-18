package org.tutorial.entity.many_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tutorial.embeddable.many_to_many.ProfessorDetails;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;

    @Embedded
    @AssociationOverride(
            name = "professors",
            joinTable = @JoinTable(
                    name = "student_prof",
                    joinColumns = {@JoinColumn(name = "student")},
                    inverseJoinColumns = {@JoinColumn(name = "professor")}
            )
    )
    private ProfessorDetails professorDetails;
}
