package MyProject.repositories;

import MyProject.entities.Articles;
import MyProject.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Integer> {

    List<Balance> findAllByOrderByBalIdAsc();

    List<Balance> getAllByCreateDate(java.sql.Timestamp timestamp);

    @Transactional
    void deleteAllByCreateDate(java.sql.Timestamp timestamp);
}
