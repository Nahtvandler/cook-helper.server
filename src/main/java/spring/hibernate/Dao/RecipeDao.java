package spring.hibernate.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.hibernate.entity.Ingredient;
import spring.hibernate.entity.Recipe;
import spring.hibernate.repository.IngridientRepository;
import spring.hibernate.repository.RecipeRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class RecipeDao {

    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeDao(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> recipeList.add(recipe));
        return recipeList;
    }

    public Recipe getById(Integer id) {
        Optional<Recipe> optional = recipeRepository.findById(id);

        return optional.isPresent() ? optional.get() : null;
    }

    public List<Recipe> getRecipeListByIngredientList(List<String> ingredientList) {
//        Long startTime = System.currentTimeMillis();
//        System.out.println("get Recipe start");
        List<Recipe> recipeList = recipeRepository.getRecipeByIngredientArray1(ingredientList);
//        System.out.println("get Recipe end: " + (System.currentTimeMillis() - startTime));
        return recipeList;
    }


}
