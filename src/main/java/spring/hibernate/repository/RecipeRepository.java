package spring.hibernate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring.hibernate.entity.Ingredient;
import spring.hibernate.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

//    @Query("SELECT company FROM Company company WHERE company.id=:id")
//    Company findById1(@Param("id") Integer id);
//    @Override
//    @Query("SELECT recipe FROM Recipe recipe WHERE recipe.id=:id")
////    Recipe findById(@Param("id") Integer id);
//
//    @Query("SELECT recipe FROM Recipe recipe join recipe.ingredients ingredient where ingredient.name in (:ingredientArray)")
////    List<Recipe> getRecipeByIngridientArray(@Param(":ingridientArray") List<Ingredient> ingredientList);
//    List<Recipe> getRecipeByIngredientArray(@Param("ingredientArray") String[] ingredientArray);

    @Query("SELECT recipe FROM Recipe recipe join recipe.ingredients ingredient where ingredient.name in (:ingredientArray)")
//    List<Recipe> getRecipeByIngridientArray(@Param(":ingridientArray") List<Ingredient> ingredientList);
    List<Recipe> getRecipeByIngredientArray1(@Param("ingredientArray") List<String> ingredientList);
}
