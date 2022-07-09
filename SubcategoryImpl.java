package com.example.demo.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CATEGORY;

import com.example.demo.model.SUBCATEGORY;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.SubcategotyRepository;

@Service
public class SubcategoryImpl implements SubcaregoryService{
	@Autowired 
	SubcategotyRepository subcatRepo;
	
	@Autowired
	CategoryRepository catRepo;

	@Override
	public String create(String name, int category_id, MultipartFile videoFile) throws IOException {
		SUBCATEGORY subcat= new SUBCATEGORY();
		subcat.setSubcategory_name(name);
		subcat.setCategory_id(category_id);
		String fileName = StringUtils.cleanPath(videoFile.getOriginalFilename());
		subcat.setVideo(fileName);
		
		SUBCATEGORY sub=subcatRepo.save(subcat);
		
		String uploadDir = "./src/main/resources/static/video/" + sub.getId();
		Path uploadPath = Paths.get(uploadDir);
		 
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
	 
		try (InputStream inputStream = videoFile.getInputStream()) {
			Path filePath =uploadPath.resolve(fileName);
			System.out.print(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {        
			throw new IOException("Could not save image file: " + videoFile, ioe);
		} 
		return null;
	}

	@Override
	public List<CATEGORY> getCategory() {
		return catRepo.findAll();
	}

	@Override
	public List<SUBCATEGORY> getSubCategory() {
		// TODO Auto-generated method stub
		return subcatRepo.findAll();
	}
	
	
	//delete

	@Override
	public void deleteSubcategory(Integer id) {
		subcatRepo.deleteById(id);
		
	}
	@Override
	public SUBCATEGORY  getSubcategoryById(Integer id) {
		
		Optional<SUBCATEGORY> optional = subcatRepo.findById(id);
		SUBCATEGORY subcategory = null;
	if(optional.isPresent()) {
		subcategory = optional.get();
				}else {
		throw new RuntimeException("type of subcategory not found for id : :"+id);
	}
		return subcategory	;
		}

	@Override
	public Optional<SUBCATEGORY> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

