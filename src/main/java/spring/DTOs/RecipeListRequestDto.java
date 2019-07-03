package spring.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecipeListRequestDto {

    @JsonProperty(value = "ingredients")
    public List<String> ingredientList;

    public List<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
