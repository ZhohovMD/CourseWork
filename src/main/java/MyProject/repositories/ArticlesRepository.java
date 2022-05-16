package MyProject.repositories;

import MyProject.entities.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer> {

    Articles findByArtId(Integer id);

    Articles findByName(String name);

    List<Articles> findAllByOrderByArtIdAsc();

    @Transactional
    void deleteByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE budget.public.articles a " +
                   "SET name = :newName " +
                   "WHERE id = :id", nativeQuery = true)
    void updateName(@Param("id") Integer id, @Param("newName") String name);
}
