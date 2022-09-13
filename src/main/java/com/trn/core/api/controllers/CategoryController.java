package com.trn.core.api.controllers;

import com.trn.core.api.entities.Category;
import com.trn.core.api.payloads.ApiResponse;
import com.trn.core.api.payloads.CategoryDto;
import com.trn.core.api.payloads.UserDto;
import com.trn.core.api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new  ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);

    }
    //delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted successfully",true),HttpStatus.OK);
    }

    //get

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto category = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);

    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

}
