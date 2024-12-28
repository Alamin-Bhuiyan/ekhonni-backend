package  com.ekhonni.backend.respository;

import com.ekhonni.backend.model.OrderCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCollectionRepository extends JpaRepository<OrderCollection, Long>{
}
