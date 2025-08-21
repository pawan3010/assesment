package com.nimap.assesment.category;

import com.nimap.assesment.common.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Page<Category> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Category create(Category c) {
        return repo.save(c);
    }

    public Category getById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category not found: " + id));
    }

    public Category update(Long id, Category in) {
        Category c = getById(id);
        c.setName(in.getName());
        c.setDescription(in.getDescription());
        return repo.save(c);
    }

    public void delete(Long id) {
        Category c = getById(id);
        repo.delete(c);
    }
}
