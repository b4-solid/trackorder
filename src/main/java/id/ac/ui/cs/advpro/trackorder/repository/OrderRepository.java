package id.ac.ui.cs.advpro.trackorder.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advpro.trackorder.models.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>{
    // ini kosong karena inheritnya dari JpaRepository yang sudah ada method-methodnya
    @Query("SELECT o FROM OrderModel o WHERE o.productId = :productId AND o.username = :username AND o.transactionId IS NULL")
    Optional<OrderModel> findbyProductIdAndUsername(long productId, String username);

    @Query("SELECT o FROM OrderModel o WHERE o.username = :username")
    List<OrderModel> findByUsernameAdmin(String username);

    @Query("SELECT o FROM OrderModel o WHERE o.username = :username AND o.transactionId IS NULL")
    List<OrderModel> findByUsername(String username);

    @Query("SELECT o FROM OrderModel o WHERE o.transactionId = :transactionId")
    List<OrderModel> findByTransactionId(String transactionId);

    @Query("SELECT o FROM OrderModel o WHERE o.productId = :productId and o.amount > :remainder")
    List<OrderModel> findByProductIdAndAmountGreaterThan(long productId, long remainder);
}