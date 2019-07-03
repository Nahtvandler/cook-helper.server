package spring.hibernate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring.hibernate.entity.Ingredient;

import java.util.List;

public interface IngridientRepository extends CrudRepository<Ingredient, Integer> {

    @Query("Select ingr from Ingredient ingr " +
            "join ingr.recipeField recipe " +
            "where recipe.id = :id")
    public List<Ingredient> findByRecipeId(@Param("id") Integer id);
}
