package id.ac.ui.cs.advpro.trackorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advpro.trackorder.models.order;

@Repository
public interface OrderRepository extends JpaRepository<order, Long>{
    // ini kosong karena inheritnya dari JpaRepository yang sudah ada method-methodnya
}