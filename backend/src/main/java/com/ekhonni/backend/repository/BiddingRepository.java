//package com.ekhonni.backend.repository;
//
//import com.ekhonni.backend.model.Bidding;
//import com.ekhonni.backend.model.Product;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import java.util.List;
//
//@CrossOrigin
//@RepositoryRestResource
//public interface BiddingRepository extends CrudRepository<Bidding, Long> {
//   List<Bidding> findByProductId(Long id);
//
//   List<Bidding> findByProductIdAndBuyerId(Long p_id, Long b_id);
//
//
//}
