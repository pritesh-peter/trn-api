package com.trn.core.api.services.impl;

import com.trn.core.api.payloads.CategoryDto;
import com.trn.core.api.repositories.CategoryRepo;
import com.trn.core.api.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return null;
    }
}
