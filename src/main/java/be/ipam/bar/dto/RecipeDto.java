package be.ipam.bar.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link be.ipam.bar.model.Recipe}
 */
@Value
public class RecipeDto implements Serializable {
    int recipeId;
    String description;
    String image;
    String name;
}