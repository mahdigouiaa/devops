package tn.iit.storemanagement.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.CategoryDto;
import tn.iit.storemanagement.service.CategoryService;

import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/categories")
@RestController()
public class CategoryResource {
    private final CategoryService categoryService;
    @Autowired
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategoryDto findOne(@PathVariable("id") long id) {
        return this.categoryService.findOne (id);
    }

    @GetMapping
    public Collection<CategoryDto> findAll(){
        return this.categoryService.findAll ();
    }

    @PostMapping
    public CategoryDto add(@RequestBody CategoryDto categoryDto){
        return this.categoryService.save (categoryDto);
    }

    @PutMapping
    public CategoryDto update(@RequestBody CategoryDto categoryDto){
        return this.categoryService.save (categoryDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.categoryService.deleteById (id);
    }
}
