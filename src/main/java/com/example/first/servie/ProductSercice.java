package com.example.first.servie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.first.dto.reponse.CategoryDTO;
import com.example.first.dto.reponse.ProductDTO;
import com.example.first.dto.repuest.CreateProductRequest;
import com.example.first.entity.CategoryEntity;
import com.example.first.entity.ProductEntity;
import com.example.first.repository.CategoryRepository;
import com.example.first.repository.ProductRepository;

@Service
public class ProductSercice {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductSercice(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public ProductDTO crateProduct(CreateProductRequest newProduct) {
		CategoryEntity existCategoryEntity = categoryRepository.findById(newProduct.getCid()).get();
		if (existCategoryEntity == null) {
			return null;
		}
		ProductEntity newPrdEntity = new ProductEntity();
		newPrdEntity.setCategory(existCategoryEntity);
		newPrdEntity.setDescription(newProduct.getDescription());
		newPrdEntity.setImage(newProduct.getImage());
		newPrdEntity.setName(newProduct.getName());
		newPrdEntity.setPrice(newProduct.getPrice());
		newPrdEntity.setQuantity(newProduct.getQuantity());

		ProductEntity crateProduct = productRepository.save(newPrdEntity);
		ProductDTO newDto = new ProductDTO();
		newDto.setCid(crateProduct.getId());
		newDto.setDescription(crateProduct.getDescription());
		newDto.setImage(crateProduct.getImage());
		newDto.setName(crateProduct.getName());
		newDto.setPrice(crateProduct.getPrice());
		newDto.setQuantity(crateProduct.getQuantity());
		newDto.setCategory(new CategoryDTO(crateProduct.getCategory().getId(), crateProduct.getCategory().getName(),
				crateProduct.getCategory().getDescription()));
		return newDto;

	}

	public ProductDTO updateProduct(CreateProductRequest newProduct, Long id) {
		CategoryEntity existCategoryEntity = categoryRepository.findById(newProduct.getCid()).get();
		if (existCategoryEntity == null) {
			return null;
		}
		ProductEntity newPrdEntity = new ProductEntity();
		newPrdEntity.setId(id);
		newPrdEntity.setCategory(existCategoryEntity);
		newPrdEntity.setDescription(newProduct.getDescription());
		newPrdEntity.setImage(newProduct.getImage());
		newPrdEntity.setName(newProduct.getName());
		newPrdEntity.setPrice(newProduct.getPrice());
		newPrdEntity.setQuantity(newProduct.getQuantity());

		ProductEntity crateProduct = productRepository.save(newPrdEntity);
		ProductDTO newDto = new ProductDTO();
		newDto.setCid(crateProduct.getId());
		newDto.setDescription(crateProduct.getDescription());
		newDto.setImage(crateProduct.getImage());
		newDto.setName(crateProduct.getName());
		newDto.setPrice(crateProduct.getPrice());
		newDto.setQuantity(crateProduct.getQuantity());
		newDto.setCategory(new CategoryDTO(crateProduct.getCategory().getId(), crateProduct.getCategory().getName(),
				crateProduct.getCategory().getDescription()));
		return newDto;

	}

	public Page<ProductDTO> getListProduct(Pageable pageable) {
		Page <ProductEntity> result = productRepository.findAll(pageable);
		List<ProductDTO> listProduct = new ArrayList<ProductDTO>();
		for (ProductEntity productEntity : result) {
			ProductDTO dto = new ProductDTO();
			dto.setCid(productEntity.getId());
			dto.setDescription(productEntity.getDescription());
			dto.setImage(productEntity.getImage());
			dto.setName(productEntity.getName());
			dto.setPrice(productEntity.getPrice());
			dto.setQuantity(productEntity.getQuantity());
			dto.setCategory(new CategoryDTO(productEntity.getCategory().getId(), productEntity.getCategory().getName(),
					productEntity.getCategory().getDescription()));
			listProduct.add(dto);

		}
		return new PageImpl<ProductDTO>(listProduct, pageable , result.getTotalElements());
	}

	public ProductDTO getProductDetail(Long id) {
		ProductEntity productEntity = productRepository.findById(id).get();
		ProductDTO dto = new ProductDTO();
		dto.setCid(productEntity.getId());
		dto.setDescription(productEntity.getDescription());
		dto.setImage(productEntity.getImage());
		dto.setName(productEntity.getName());
		dto.setPrice(productEntity.getPrice());
		dto.setQuantity(productEntity.getQuantity());
		dto.setCategory(new CategoryDTO(productEntity.getCategory().getId(), productEntity.getCategory().getName(),
				productEntity.getCategory().getDescription()));
		return dto;
	}

	public List<ProductDTO> getTop5Product() {
		List<ProductEntity> topFivePrd = productRepository.findTop5Cheapest();
		List<ProductDTO> topFiveDtos = new ArrayList<ProductDTO>();
		for (ProductEntity productEntity : topFivePrd) {
			ProductDTO dto = new ProductDTO();
			dto.setCid(productEntity.getId());
			dto.setDescription(productEntity.getDescription());
			dto.setImage(productEntity.getImage());
			dto.setName(productEntity.getName());
			dto.setPrice(productEntity.getPrice());
			dto.setQuantity(productEntity.getQuantity());
			dto.setCategory(new CategoryDTO(productEntity.getCategory().getId(), productEntity.getCategory().getName(),
					productEntity.getCategory().getDescription()));
			topFiveDtos.add(dto);

		}
		return topFiveDtos;
	}

	public List<ProductDTO> getListByCid(Long id) {
		List<ProductEntity> listProducts = productRepository.findByCid(id);
		List<ProductDTO> listDtos = new ArrayList<ProductDTO>();
		for (ProductEntity productEntity : listProducts) {
			ProductDTO dto = new ProductDTO();
			dto.setCid(productEntity.getId());
			dto.setDescription(productEntity.getDescription());
			dto.setImage(productEntity.getImage());
			dto.setName(productEntity.getName());
			dto.setPrice(productEntity.getPrice());
			dto.setQuantity(productEntity.getQuantity());
			dto.setCategory(new CategoryDTO(productEntity.getCategory().getId(), productEntity.getCategory().getName(),
					productEntity.getCategory().getDescription()));
			listDtos.add(dto);

		}
		return listDtos;
	}

	public List<ProductDTO> getListMostProduct() {
		Long categoryId = productRepository.findMostCid().get(0);
		if (categoryId == null) {
			return null;
		}
		List<ProductDTO> listDto = getListByCid(categoryId);
		return listDto;
	}

}
