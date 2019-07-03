package spring.hibernate.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.hibernate.entity.Ingredient;
import spring.hibernate.repository.IngridientRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class IngredientDao {

    private IngridientRepository ingridientRepository;

    public IngredientDao(IngridientRepository ingridientRepository) {
        this.ingridientRepository = ingridientRepository;
    }

    public List<Ingredient> getAllingridients() {
        List<Ingredient> ingredientList = new ArrayList<>();
        Iterable<Ingredient> ingridients = ingridientRepository.findAll();

        ingridients.forEach(ingredient -> ingredientList.add(ingredient));
        return ingredientList;
    }

    public List<Ingredient> getIngridientListByRecipeId(Integer id) {
        return ingridientRepository.findByRecipeId(id);
    }

    public Ingredient getIngridientById(Integer id) {
        Optional<Ingredient> optional = ingridientRepository.findById(id);

        return optional.isPresent() ? optional.get() : null;
    }
}
