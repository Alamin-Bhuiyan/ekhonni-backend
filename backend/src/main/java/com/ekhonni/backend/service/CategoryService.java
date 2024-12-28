package  com.ekhonni.backend.service;

import com.ekhonni.backend.model.Category;
import com.ekhonni.backend.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category create(Category newCategory) {
        return categoryRepository.save(new Category(
                newCategory.getImg(),
                newCategory.getTitle(),
                newCategory.getSubtitle()
        ));
    }

    public Category update(Long id, Category updatedCategory) {
       return categoryRepository.findById(id).map(
            category -> {
                category.setImg(updatedCategory.getImg());
                category.setTitle(updatedCategory.getTitle());
                category.setSubtitle(updatedCategory.getSubtitle());
                return categoryRepository.save(category);
            }
        ).orElse(null);
    }

    public String deleteById(Long id) {
        categoryRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
