package spring.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ingridient")
public class Ingredient implements Serializable {

    @Id
    @Column(name = "ingridientid")
    private Integer ingredientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeid")
    private Recipe recipeField;

    @Column(name = "name")
    private String name;

    @Column(name = "additionalinfo")
    private String additionalInfo;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }


    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingridientId) {
        this.ingredientId = ingridientId;
    }

    public Recipe getRecipeField() {
        return recipeField;
    }

    public void setRecipeField(Recipe recipeField) {
        this.recipeField = recipeField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                '}';
    }
}
