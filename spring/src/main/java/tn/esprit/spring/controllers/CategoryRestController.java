package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Category;
import tn.esprit.spring.services.ICategoryServices;

import java.util.List;

@Tag(name = "\uD83D\uDC69\u200D\uD83C\uDFEB Category Management")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {
    private final ICategoryServices categoryServices;

    @Operation(description = "Add Category")
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        return categoryServices.addCategory(category);
    }

    @Operation(description = "Retrieve all Categories")
    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryServices.retrieveAllCategory();
    }

    @Operation(description = "Update Category")
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category){
        return categoryServices.updateCategory(category);
    }

    @Operation(description = "Retrieve Category by Id")
    @GetMapping("/get/{id-Category}")
    public Category getCategoryById(@PathVariable("id-Category") Long categoryId){
        return categoryServices.retrieveCategory(categoryId);
    }

    @Operation(description = "Delete Category by Id")
    @DeleteMapping("/delete/{id-Category}")
    public void deleteCategoryById(@PathVariable("id-Category") Long categoryId){
        categoryServices.removeCategory(categoryId);
    }
}
