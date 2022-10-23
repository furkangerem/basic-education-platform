import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.BaseLogger;
import core.logging.DatabaseLogger;
import core.logging.EmailLogger;
import core.logging.FileLogger;
import dataAccess.HibernateCourseDao;
import dataAccess.JdbcCategoryDao;
import dataAccess.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<BaseLogger> loggers = new ArrayList<BaseLogger>();
        loggers.add(new DatabaseLogger());
        loggers.add(new EmailLogger());
        loggers.add(new FileLogger());

        Course course = new Course(1, "Let's Learn Java", 69.99);
        Course course1 = new Course(1, "Let's Learn Python", 79.99);
        Course course2 = new Course(1, "Let's Learn C#", 89.99);

        List<Course> courseList = new ArrayList<Course>();
        courseList.add(course1);
        courseList.add(course2);

        CourseManager courseManager = new CourseManager(new HibernateCourseDao(), courseList, loggers);
        courseManager.addCourse(course);

        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1, "Programming");
        Category category1 = new Category(2, "Testing");
        Category category2 = new Category(1, "Devops");
        categoryList.add(category);
        categoryList.add(category1);

        CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), categoryList, loggers);
        categoryManager.addCategory(category2);

        List<Instructor> instructorList = new ArrayList<Instructor>();
        Instructor instructor = new Instructor(1, "Engin", "DEMİROĞ");
        Instructor instructor1 = new Instructor(2, "Furkan", "GEREM");
        Instructor instructor2 = new Instructor(3, "Muhammed Furkan", "GEREM");
        instructorList.add(instructor);
        instructorList.add(instructor1);

        InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(), instructorList, loggers);
        instructorManager.addInstructor(instructor2);
    }
}