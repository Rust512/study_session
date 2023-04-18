package org.tutorial.entity.one_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tutorial.embeddable.one_to_many.DepartmentDetails;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;


    @Embedded
    @AttributeOverride(
            name = "contactNo",
            column = @Column(name = "contact_no")
    )
    @AssociationOverride(
            name = "department",
            joinColumns = {@JoinColumn(name = "allocated_department")}
    )
    private DepartmentDetails departmentDetails;
}
