package business;

import core.logging.BaseLogger;
import dataAccess.CourseDao;
import entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private CourseDao courseDao;
    private List<Course> courseList;
    private List<BaseLogger> loggers;

    public CourseManager(CourseDao courseDao, List<Course> courseList, List<BaseLogger> loggers) {

        this.courseDao = courseDao;
        this.courseList = courseList;
        this.loggers = loggers;
    }

    public void addCourse(Course course) throws Exception {

        for (Course courseListItem : courseList) {

            if (courseListItem.getCourseName().equals(course.getCourseName())) {
                throw new Exception("You can't create a course with the same name.");
            }
        }

        if (course.getCoursePrice() < 0) {
            throw new Exception("The price must be greater than 0 or equal.");
        }

        courseDao.addCourse(course);

        for (BaseLogger logger : loggers) {
            logger.Logger("Logged: " + course.getCourseName());
        }
    }
}
