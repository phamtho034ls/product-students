package com.example.first.servie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.first.dto.reponse.CategoryDTO;
import com.example.first.entity.CategoryEntity;
import com.example.first.repository.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryDTO> getListCategory() {
		List<CategoryEntity> reult = categoryRepository.findAll();
		// Chuyển dữ liệu entity sang DTO
		List<CategoryDTO> listCategories = new ArrayList<CategoryDTO>();
		for (CategoryEntity categoryEntity : reult) {
			CategoryDTO dto = new CategoryDTO(categoryEntity.getId(), categoryEntity.getName(),
					categoryEntity.getDescription());
			listCategories.add(dto);
		}
		return listCategories;
	}

	public CategoryDTO saveCategory(CategoryEntity newCategory) {
		CategoryEntity cate = categoryRepository.save(newCategory);
		CategoryDTO dto = new CategoryDTO();
		dto.setId(cate.getId());
		dto.setDescription(cate.getDescription());
		dto.setName(cate.getName());
		return dto;
	}

	public boolean deleteCategory(Long id) {
		boolean isExist = categoryRepository.existsById(id);
		if (isExist) {
			categoryRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public CategoryDTO getCategoryDetail(Long id) {
		CategoryEntity cate = categoryRepository.findById(id).get();
		CategoryDTO dto = new CategoryDTO(cate.getId(), cate.getName(), cate.getDescription());
		return dto;
	}
}
