package be.ipam.bar.controller;

import be.ipam.bar.dto.RecipeDto;
import be.ipam.bar.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // CRUD operations

    // GET Read 1 recipe by id
    @GetMapping("/{id}") // récupérer une recette par son identifiant
    public ResponseEntity<RecipeDto> findRecipeById(@PathVariable int id) {
        Optional<RecipeDto> recipe = recipeService.getRecipeById(id); // Récupération de la recette
        return recipe.map(ResponseEntity::ok) // Si la recette est trouvée, retourne 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon, retourne 404 Not Found
    }

    // POST Create 1 recipe
    @PostMapping() // créer une nouvelle recette
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto recipe = recipeService.createRecipe(recipeDto); // Création de la recette
        return ResponseEntity.status(HttpStatus.CREATED).body(recipe); // Retourne 201 Created avec la recette créée
    }

    // PUT Update 1 recipe
    @PutMapping("/{id}") // mettre à jour une recette existante
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable int id, @RequestBody RecipeDto recipeDto) {
        Optional<RecipeDto> recipe = recipeService.updateRecipe(id, recipeDto); // Mise à jour de la recette
        return recipe.map(ResponseEntity::ok) // Si la recette est mise à jour, retourne 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon, retourne 404 Not Found
    }


    // DELETE Delete 1 recipe
    @DeleteMapping("/{id}") // supprimer une recette par son identifiant
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        boolean isDeleted = recipeService.deleteRecipe(id); // Suppression de la recette
        return isDeleted // Retourne 204 No Content si supprimée, sinon 404 Not Found
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    /*
    // PATCH Partial update 1 recipe
    @PatchMapping("/{id}") //une mise à jour partielle d'une recette
    public ResponseEntity<RecipeDto> updatePartialRecipe(@PathVariable int id, @RequestBody RecipeDto recipeDto) {
        Optional<RecipeDto> recipe = recipeService.updatePartialRecipe(id, recipeDto); // Mise à jour partielle de la recette
        return recipe.map(ResponseEntity::ok) // Si la recette est mise à jour, retourne 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon, retourne 404 Not Found
    }
    */

    /*
    @GetMapping("/name/{name}") // récupérer une recette par son nom
    public ResponseEntity<Recipe> findRecipeByName(@PathVariable String name) {
        Optional<Recipe> recipe = recipeService.getRecipeByName(name); // Récupération de la recette par nom
        return recipe.map(ResponseEntity::ok) // Si trouvé, retourne 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon, retourne 404 Not Found
    }
    */
}
