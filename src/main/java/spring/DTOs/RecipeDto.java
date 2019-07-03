package spring.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecipeDto {

    @JsonProperty(value = "recipeName")
    public String name;

    @JsonProperty(value = "cookTime")
    public Integer cookTime;

    @JsonProperty(value = "ingredients")
    public List<String> ingredients;

    @JsonProperty(value = "algorithm")
    public String algorithm;

    @JsonProperty(value = "searchAccuracy")
    public Double accuracy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }
}
