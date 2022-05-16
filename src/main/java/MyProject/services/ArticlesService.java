package MyProject.services;

import MyProject.entities.Articles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import MyProject.repositories.ArticlesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticlesService {

    private final ArticlesRepository articlesRepository;

    public void save(Articles article) {
        articlesRepository.save(article);
    }

    public void saveAll(List<Articles> articles) {
        articlesRepository.saveAll(articles);
    }

    public void saveByParameters(String name) {
        articlesRepository.save(new Articles().setName(name));
    }

    public void updateName(Integer id, String name) {
        articlesRepository.updateName(id, name);
    }

    public Articles getArticleById(Integer id) {
        return articlesRepository.findByArtId(id);
    }

    public Articles getArticleByName(String name) {
        return articlesRepository.findByName(name);
    }

    public List<Articles> getAll() {
        return articlesRepository.findAllByOrderByArtIdAsc();
    }

    public void deleteById(Integer id) {
        articlesRepository.deleteById(id);
    }

    public void deleteByName(String name) {
        articlesRepository.deleteByName(name);
    }

    public void deleteAll() {
        articlesRepository.deleteAll();
    }

}
