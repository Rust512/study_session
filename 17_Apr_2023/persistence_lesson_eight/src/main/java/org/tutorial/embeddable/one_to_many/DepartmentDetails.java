package org.tutorial.embeddable.one_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tutorial.entity.one_to_many.Department;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DepartmentDetails {
    @ManyToOne
    private Department department;
    private String contactNo;
}
