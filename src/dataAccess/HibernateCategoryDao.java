package dataAccess;

import entities.Category;

public class HibernateCategoryDao implements CategoryDao {

    @Override
    public void addCategory(Category category) {

        System.out.println("Added:" + category.getCategoryName() + "data to database with Hibernate");
    }
}
