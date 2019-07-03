package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.DTOs.RecipeListRequestDto;
import spring.DTOs.RecipeListResponseDto;

import spring.hibernate.entity.Ingredient;
import spring.service.CookHelperService;

import java.util.List;

@Controller
@RequestMapping("/cookHelper")
@Transactional
public class CookHelperController {

    @Autowired
    CookHelperService cookHelperService;

    public CookHelperController(CookHelperService cookHelperService) {
        this.cookHelperService = cookHelperService;
    }

    @RequestMapping("/ingrByRecId")
    public @ResponseBody String getIngridientListByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        List<Ingredient> ingredientList = cookHelperService.getIngredientListByREcipeId(recipeId);

        StringBuilder builder = new StringBuilder();
        ingredientList.forEach(ingredient -> builder.append(ingredient.getName()).append("\n"));

        return builder.toString();
    }

    @RequestMapping(value = "/recipeList", method = RequestMethod.POST)
    public @ResponseBody() RecipeListResponseDto getResipeList(@RequestBody RecipeListRequestDto request) {

        if (request.getIngredientList() == null || request.getIngredientList().isEmpty()) {
            // TODO return error
        }

        RecipeListResponseDto response = new RecipeListResponseDto();
        response.setRecipeList(cookHelperService.getRecipeListByIngridients(request.getIngredientList()));

        return response;
    }
}
