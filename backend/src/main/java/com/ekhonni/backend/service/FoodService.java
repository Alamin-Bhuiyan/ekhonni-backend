package  com.ekhonni.backend.service;

import com.ekhonni.backend.model.Food;
import com.ekhonni.backend.respository.CategoryRepository;
import com.ekhonni.backend.respository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository, CategoryRepository categoryRepository) {
        this.foodRepository = foodRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Food> findAll(){
        return foodRepository.findAll();
    }

    public Food findById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    public Food create(Food newFood) {
       return categoryRepository.findById(newFood.getCategory().getId()).map(
           category -> foodRepository.save(new Food(
               newFood.getImg(),
               newFood.getTitle(),
               newFood.getPrice(),
               true,
               newFood.getDescription(),
               category))
       ).orElse(null);
    }

    public Food update(Long id, Food updatedFood) {
        return foodRepository.findById(id).flatMap(
            food -> categoryRepository.findById(updatedFood.getCategory().getId()).map(
            category -> {
                food.setImg(updatedFood.getImg());
                food.setTitle(updatedFood.getTitle());
                food.setPrice(updatedFood.getPrice());
                food.setAvailable(updatedFood.isAvailable());
                food.setDescription(updatedFood.getDescription());
                food.setCategory(category);
                return foodRepository.save(food);
            })).orElse(null);
    }

    public String deleteById(Long id) {
        foodRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
