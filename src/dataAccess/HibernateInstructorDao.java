package dataAccess;

import entities.Instructor;

public class HibernateInstructorDao implements InstructorDao {

    @Override
    public void addInstructor(Instructor instructor) {

        System.out.println("Added:" + instructor.getInstructorFirstName() + " " + instructor.getInstructorLastName() + " data to database with JDBC.");
    }
}
