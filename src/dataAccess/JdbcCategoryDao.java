package dataAccess;

import entities.Category;

public class JdbcCategoryDao implements CategoryDao{

    @Override
    public void addCategory(Category category) {

        System.out.println("Added:" + category.getCategoryName() + "data to database with JDBC.");
    }
}
