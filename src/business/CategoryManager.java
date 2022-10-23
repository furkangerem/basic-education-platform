package business;

import core.logging.BaseLogger;
import dataAccess.CategoryDao;
import entities.Category;

import java.util.List;

public class CategoryManager {

    private CategoryDao categoryDao;
    private List<Category> categoryList;
    private List<BaseLogger> loggers;

    public CategoryManager(CategoryDao categoryDao, List<Category> categoryList, List<BaseLogger> loggers) {

        this.categoryDao = categoryDao;
        this.categoryList = categoryList;
        this.loggers = loggers;
    }

    public void addCategory(Category category) throws Exception{

        for (Category categoryListItem : categoryList) {

            if (categoryListItem.getCategoryName().equals(category.getCategoryName())){
                throw new Exception("You can't create a category with the same name.");
            }
        }

        categoryDao.addCategory(category);

        for(BaseLogger logger:loggers){
            logger.Logger("Logged: " + category.getCategoryName());
        }
    }
}
