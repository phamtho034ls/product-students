package com.example.first.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.reponse.ProductDTO;
import com.example.first.dto.repuest.CreateProductRequest;
import com.example.first.entity.ProductEntity;
import com.example.first.model.Product;
import com.example.first.servie.ProductSercice;

@RestController
@RequestMapping("/product")
public class ProductController {

	// 400, 401, 403, 500, 503, 200
	@Autowired
	ProductSercice productSercice;

	@PostMapping("/create")
	public ProductDTO createProduct(@RequestBody CreateProductRequest bodyProductRequest) {

		ProductDTO newPrd = productSercice.crateProduct(bodyProductRequest);
		return newPrd;
	}

	@PutMapping("/update/{id}")
	public ProductDTO updateProduct(@RequestBody CreateProductRequest bodyProductRequest, @PathVariable Long id) {
		ProductDTO newPrd = productSercice.updateProduct(bodyProductRequest, id);
		return newPrd;
	}

	@GetMapping("/list")
	public Page<ProductDTO> getListProduct(@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int pageSize  ) {
		Pageable pageable = PageRequest.of(page, pageSize, Sort.by("name"));
		return productSercice.getListProduct(pageable);
	}
	@GetMapping("/detail/{id}")
	public ProductDTO getProductDetail(@PathVariable Long id) {
		return productSercice.getProductDetail(id);
	}
	@GetMapping("/top5")
	public List<ProductDTO> getTopFive()
	{
		return productSercice.getTop5Product();
	}
	@GetMapping("/list-most")
	public List<ProductDTO> getListMostProduct()
	{
		return productSercice.getListMostProduct();
	}

}
