//package com.ekhonni.backend.repository;
//
//import com.ekhonni.backend.model.Product;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import java.util.List;
//
//@RepositoryRestResource
//@CrossOrigin
//public interface ProductRepository extends CrudRepository<Product, Long> {
//
//    List<Product> findAllByCategoryContains(String category);
//    List<Product> findBySellerId(Long id);
//}
