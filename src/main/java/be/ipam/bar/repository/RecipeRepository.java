package be.ipam.bar.repository;

import be.ipam.bar.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Optional<Recipe> findByName(@Param("recipeName") String recipeName);
}
