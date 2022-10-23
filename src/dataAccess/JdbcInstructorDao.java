package dataAccess;

import entities.Instructor;

public class JdbcInstructorDao implements InstructorDao {

    @Override
    public void addInstructor(Instructor instructor) {

        System.out.println("Added:" + instructor.getInstructorFirstName() + " " + instructor.getInstructorLastName() + " data to database with JDBC.");
    }
}
