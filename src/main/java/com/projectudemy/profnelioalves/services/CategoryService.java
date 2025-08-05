package com.projectudemy.profnelioalves.services;

import com.projectudemy.profnelioalves.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import com.projectudemy.profnelioalves.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
