package MyProject.controller;

import MyProject.entities.Articles;
import MyProject.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private ArticlesService articlesService;

    @Autowired
    public void setArticlesService(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping("")
    public ModelAndView start() {
        ModelAndView model = new ModelAndView();
        model.setViewName("articles");
        return model;
    }

    @GetMapping("/save")
    public ModelAndView addArticles(@RequestParam("name") String name){
        articlesService.saveByParameters(name);
        ModelAndView model = new ModelAndView();
        model.setViewName("articles");
        return model;
    }

    @GetMapping("/get/byId")
    public ModelAndView getById(@RequestParam("id") Integer id) {
        ModelAndView model = new ModelAndView();
        List<Articles> list = new ArrayList<>(
                List.of(
                        articlesService.getArticleById(id)));
        model.addObject("list", list);
        model.setViewName("articlesGET");
        return model;
    }

    @GetMapping("/get/byName")
    public ModelAndView getByName(@RequestParam("name") String name) {
        ModelAndView model = new ModelAndView();
        List<Articles> list = new ArrayList<>(
                List.of(
                        articlesService.getArticleByName(name)));
        model.addObject("list", list);
        model.setViewName("articlesGET");
        return model;
    }

    @GetMapping("/get/all")
    public ModelAndView getAll() {
        ModelAndView model = new ModelAndView();
        List<Articles> list = articlesService.getAll();
        model.addObject("list", list);
        model.setViewName("articlesGET");
        return model;
    }

    @GetMapping("/put")
    public ModelAndView putName(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        articlesService.updateName(id, name);
        ModelAndView model = new ModelAndView();
        model.setViewName("articles");
        return model;
    }

    @GetMapping("/delete/byId")
    public ModelAndView deleteById(@RequestParam("id") Integer id) {
        articlesService.deleteById(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("articles");
        return model;
    }

    @GetMapping("/delete/byName")
    public ModelAndView deleteByName(@RequestParam("name") String name) {
        articlesService.deleteByName(name);
        ModelAndView model = new ModelAndView();
        model.setViewName("articles");
        return model;
    }

    @GetMapping("/delete/all")
    public ModelAndView deleteAll() {
        articlesService.deleteAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("articles");
        return model;
    }

}
