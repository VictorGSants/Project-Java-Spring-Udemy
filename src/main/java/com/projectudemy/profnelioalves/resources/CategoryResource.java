package com.projectudemy.profnelioalves.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.projectudemy.profnelioalves.services.CategoryService;
import com.projectudemy.profnelioalves.entities.Category;


@RestController
@RequestMapping(value = "/categories")

public class CategoryResource {
   @Autowired
    // This annotation injects the CategoryService bean into this resource
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity <List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity findCategoryById(@PathVariable Long id){ {
        Category category = categoryService.findCategoryById(id);
        return ResponseEntity.ok().body(category);
        }
    }
}
