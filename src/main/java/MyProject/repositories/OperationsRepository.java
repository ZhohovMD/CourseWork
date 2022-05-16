package MyProject.repositories;

import MyProject.entities.Balance;
import MyProject.entities.Operations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OperationsRepository extends JpaRepository<Operations, Integer> {

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE budget.public.balance b " +
                    "SET  credit = b.credit + o.credit, " +
                    "     debit = b.debit + o.debit " +
                    "FROM budget.public.operations o " +
                    "WHERE :id = o.id AND b.id = o.balance_id; " +
                    "UPDATE budget.public.balance b " +
                    "SET amount = b.debit - b.credit " +
                    "FROM budget.public.operations o " +
                    "WHERE :id = o.id AND b.id = o.balance_id"
            , nativeQuery = true)
    void applyOpById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE budget.public.balance b " +
                    "SET  credit = b.credit - o.credit, " +
                    "     debit = b.debit - o.debit " +
                    "FROM budget.public.operations o " +
                    "WHERE :id = o.id AND b.id = o.balance_id; " +
                    "UPDATE budget.public.balance b " +
                    "SET amount = b.debit - b.credit " +
                    "FROM budget.public.operations o " +
                    "WHERE :id = o.id AND b.id = o.balance_id", nativeQuery = true)
    void undoOp(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE budget.public.operations o " +
                    "SET balance_id = :balance_id " +
                    "FROM budget.public.balance b " +
                    "WHERE :id = o.id AND :balance_id = b.id", nativeQuery = true)
    void updateBalance_id(@Param("id")Integer id, @Param("balance_id") Integer balance_id);

    @Query(value = "SELECT id FROM budget.public.balance b " +
                   "WHERE :id = b.id", nativeQuery = true)
    Integer getBalancesIdById(@Param("id") Integer id);

    @Query(
            value = "SELECT * FROM budget.public.operations o " +
                    "JOIN budget.public.articles a " +
                    "ON :name = a.name AND o.article_id = a.id", nativeQuery = true)
    List<Operations> getAllByArticlesName(@Param("name") String name);

    @Query(
            value = "SELECT * FROM budget.public.operations o " +
                    "JOIN budget.public.balance b " +
                    "ON :id = b.id AND o.balance_id = b.id", nativeQuery = true)
    List<Operations> getAllByBalance_id(@Param("id") Integer id);

    List<Operations> findAllByOrderByIdAsc();
}
