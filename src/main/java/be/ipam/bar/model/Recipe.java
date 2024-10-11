package be.ipam.bar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image")
    private String image;

    @Column(name = "Name")
    private String name;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
