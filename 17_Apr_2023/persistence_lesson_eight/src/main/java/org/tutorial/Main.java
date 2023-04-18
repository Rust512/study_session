package org.tutorial;

import org.tutorial.entity.element_collection.Document;
import org.tutorial.entity.element_collection.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-lesson-eight");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*Department department = new Department();
        department.setName("LMS");

        DepartmentDetails departmentDetails = new DepartmentDetails();
        departmentDetails.setContactNo("+91 9168405543");
        departmentDetails.setDepartment(department);

        Employee employee = new Employee();
        employee.setName("Devang");
        employee.setDepartmentDetails(departmentDetails);*/

       /* Professor professor = new Professor();
        professor.setName("Prerna");

        ProfessorDetails professorDetails = new ProfessorDetails();
        professorDetails.setProfessors(Collections.singleton(professor));

        Student student = new Student();
        student.setName("Devang");
        student.setProfessorDetails(professorDetails);*/

        Document document = new Document();
        document.setContent("Something suspicious");
        document.setIdentity(UUID.randomUUID().toString());

        Person person = new Person();
        person.setName("Ninad");
        person.setPhoneNumbers(Set.of("+91 9422449709", "+91 9820398109"));
        person.setDocuments(Collections.singleton(document));

        entityManager.getTransaction().begin();
        /*entityManager.persist(department);
        entityManager.persist(employee);*/
        /*entityManager.persist(professor);
        entityManager.persist(student);*/
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}