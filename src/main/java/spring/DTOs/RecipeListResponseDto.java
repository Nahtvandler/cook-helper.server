package spring.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import spring.hibernate.entity.Recipe;

import java.util.List;

public class RecipeListResponseDto {

    @JsonProperty(value = "recipes")
    public List<RecipeDto> recipeList;

    public List<RecipeDto> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<RecipeDto> recipeList) {
        this.recipeList = recipeList;
    }
}
