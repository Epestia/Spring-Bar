package be.ipam.bar.service;

import be.ipam.bar.dto.RecipeDto;
import be.ipam.bar.mapper.RecipeMapper;
import be.ipam.bar.model.Recipe;
import be.ipam.bar.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeMapper recipeMapper;


    public Optional<Recipe> getRecipeByName(String recipeName) {
        return recipeRepository.findByName(recipeName);
    }

    public Optional<RecipeDto> getRecipeById(int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        // Convert Recipe to RecipeDto using RecipeMapper
        return recipe.map(recipeMapper::toDto);
    }

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        recipe = recipeRepository.save(recipe);
        return recipeMapper.toDto(recipe);
    }

    // Full update (PUT)
    public Optional<RecipeDto> updateRecipe(int id, RecipeDto recipeDto) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            Recipe recipeToUpdate = recipeMapper.toEntity(recipeDto);
            recipeToUpdate.setRecipeId(id);
            recipeToUpdate = recipeRepository.save(recipeToUpdate);
            return Optional.of(recipeMapper.toDto(recipeToUpdate));
        }
        return Optional.empty();
    }

    // Partial update (PATCH)
    public Optional<RecipeDto> updatePartialRecipe(int id, RecipeDto recipeDto) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            Recipe recipeToUpdate = recipe.get();
            recipeToUpdate = recipeMapper.partialUpdate(recipeDto, recipeToUpdate);
            recipeToUpdate = recipeRepository.save(recipeToUpdate);
            return Optional.of(recipeMapper.toDto(recipeToUpdate));
        }
        return Optional.empty();
    }

    public Boolean deleteRecipe(int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            recipeRepository.delete(recipe.get());
            return true;
        }
        return false;
    }
}
