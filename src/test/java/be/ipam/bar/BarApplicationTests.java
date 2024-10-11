package be.ipam.bar;

import be.ipam.bar.model.Recipe;
import be.ipam.bar.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bar2ApplicationTests {

	@Autowired
	private RecipeRepository RecipeRepository;

	@Test
	void testAddRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(5);
		recipe.setDescription("chocolat");
		recipe.setImage("image");
		recipe.setName("Cake Chocolat");
		RecipeRepository.save(recipe);
	}

	@Test
	void contextLoads() {
	}

}
