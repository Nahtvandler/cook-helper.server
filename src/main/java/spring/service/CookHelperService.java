package spring.service;

import com.sun.javafx.binding.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.DTOs.RecipeDto;
import spring.hibernate.Dao.IngredientDao;
import spring.hibernate.Dao.RecipeDao;
import spring.hibernate.entity.Ingredient;
import spring.hibernate.entity.Recipe;
import spring.utils.StringConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@Transactional
public class CookHelperService {

    @Autowired
    RecipeDao recipeDao;

    @Autowired
    IngredientDao ingredientDao;

    public CookHelperService(RecipeDao recipeDao, IngredientDao ingredientDao) {
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;
    }

    public List<Ingredient> getIngredientListByREcipeId(Integer id) {
        return  ingredientDao.getIngridientListByRecipeId(id);
    }

//    public String getCookAlgorithmByIngridients(List<Ingredient> ingredientList) {
//        List<Recipe> recipeList = recipeDao.getRecipeListByIngredientList(ingredientList);
//
//        recipeList.forEach(recipe -> System.out.println(recipe.getName()));
//
//        return null;
//    }

    public List<RecipeDto> getRecipeListByIngridients(List<String> ingredientList) {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        Set<RecipeDto> recipeDtoSet = new HashSet<>();
        List<Recipe> recipeList = recipeDao.getRecipeListByIngredientList(ingredientList);

        recipeList.forEach(recipe -> {
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setName(recipe.getName());
            recipeDto.setCookTime(recipe.getCookTime());
            recipeDto.setAlgorithm(recipe.getAlgorithmString());

            recipeDto.setAccuracy(0D);
            recipeDto.setIngredients(new ArrayList<String>());

            Integer count = 1;
            for (Ingredient pIngredient : recipe.getIngredients()) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(String.valueOf(count)).append(StringConstants.DOT_SPACE).append(pIngredient.getName());

                String ingredientAdditionalInfo = pIngredient.getAdditionalInfo();
                if (ingredientAdditionalInfo != null && !ingredientAdditionalInfo.isEmpty()) {
                    buffer.append(StringConstants.DASH_SPACE).append(ingredientAdditionalInfo);
                }

                recipeDto.getIngredients().add(buffer.toString());
                if (ingredientList.contains(pIngredient.getName())) {
                    recipeDto.setAccuracy(recipeDto.getAccuracy() + 1);
                }
                count++;
            }

//            recipe.getIngredients().forEach(ingredient -> {
//                recipeDto.getIngredients().add(ingredient.getName()
//                        + StringConstants.DASH_SPACE + ingredient.getAdditionalInfo());
//                if (ingredientList.contains(ingredient.getName())) {
//                    recipeDto.setAccuracy(recipeDto.getAccuracy() + 1);
//                }
//            });

            Double actualAccuracy = recipeDto.getAccuracy() / recipeDto.getIngredients().size();
            actualAccuracy = BigDecimal.valueOf(actualAccuracy).setScale(1, RoundingMode.HALF_UP).doubleValue();
            recipeDto.setAccuracy(actualAccuracy);
            //recipeDtoList.add(recipeDto);
            recipeDtoSet.add(recipeDto);
        });

        //recipeDtoList.sort((a, b) -> b.getAccuracy().compareTo(a.getAccuracy()));
        recipeDtoSet.stream().sorted((a, b) -> b.getAccuracy().compareTo(a.getAccuracy()));

        recipeDtoSet.forEach(recipeDto -> recipeDtoList.add(recipeDto));
        return recipeDtoList;
    }
}
