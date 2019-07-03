package spring.hibernate.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cooktime")
    private Integer cookTime;

    @OneToMany(mappedBy = "recipeField")
    private List<Ingredient> ingredients;

    @Column(name = "algorithm")
    private String algorithmString;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getAlgorithmString() {
        return algorithmString;
    }

    public void setAlgorithmString(String algorithmString) {
        this.algorithmString = algorithmString;
    }
}
