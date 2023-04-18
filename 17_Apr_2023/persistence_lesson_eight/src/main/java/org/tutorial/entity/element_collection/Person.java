package org.tutorial.entity.element_collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "phone_number", joinColumns = {@JoinColumn(name = "person")})
    @Column(name = "number")
    private Set<String> phoneNumbers;

    @ElementCollection
    @CollectionTable(name = "document", joinColumns = {@JoinColumn(name = "owner")})
    @AttributeOverride(name = "identity", column = @Column(name = "identifier"))
    private Set<Document> documents;
}
