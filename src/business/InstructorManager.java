package business;

import core.logging.BaseLogger;
import dataAccess.InstructorDao;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorManager {

    private InstructorDao instructorDao;
    private List<Instructor> instructorList;
    private List<BaseLogger> baseLoggers;

    public InstructorManager(InstructorDao instructorDao, List<Instructor> instructorList, List<BaseLogger> baseLoggers) {

        this.instructorDao = instructorDao;
        this.instructorList = instructorList;
        this.baseLoggers = baseLoggers;
    }

    public void addInstructor(Instructor instructor) throws Exception {

        for (Instructor instructorListItem : instructorList) {
            if (instructorListItem.getInstructorFirstName().equals(instructor.getInstructorFirstName())
                    && instructorListItem.getInstructorLastName().equals(instructor.getInstructorLastName())) {
                throw new Exception("You can't add an instructor with the same name and surname.");
            }
        }

        instructorDao.addInstructor(instructor);

        for (BaseLogger logger : baseLoggers) {
            logger.Logger("Logged: " + instructor.getInstructorFirstName() + " " + instructor.getInstructorLastName());
        }
    }
}
