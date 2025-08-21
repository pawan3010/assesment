package com.nimap.assesment.product;

import com.nimap.assesment.category.Category;
import com.nimap.assesment.category.CategoryRepository;
import com.nimap.assesment.common.ResourceNotFoundException;
import com.nimap.assesment.product.dto.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    public Product create(ProductRequest req) {
        Category category = categoryRepo.findById(req.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + req.categoryId()));

        Product p = Product.builder()
                .name(req.name())
                .description(req.description())
                .price(req.price())
                .category(category)
                .build();

        return productRepo.save(p);
    }

    public Product getById(Long id) {
        return productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product not found: " + id));
    }

    public Product update(Long id, ProductRequest req) {
        Product p = getById(id);
        p.setName(req.name());
        p.setDescription(req.description());
        p.setPrice(req.price());

        if (!p.getCategory().getId().equals(req.categoryId())) {
            Category category = categoryRepo.findById(req.categoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + req.categoryId()));
            p.setCategory(category);
        }
        return productRepo.save(p);
    }

    public void delete(Long id) {
        productRepo.delete(getById(id));
    }
}
