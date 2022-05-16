package MyProject.controller;

import MyProject.entities.Articles;
import MyProject.entities.Operations;
import MyProject.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    public OperationsService operationsService;

    @Autowired
    public void setOperationsService(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("")
    public ModelAndView start() {
        ModelAndView model = new ModelAndView();
        model.setViewName("operations");
        return model;
    }

    @GetMapping("/save")
    public ModelAndView addOperation(@RequestParam("article_id") Integer article_id,
                             @RequestParam("debit") Double debit,
                             @RequestParam("credit") Double credit,
                             @RequestParam("timestamp") String timestamp,
                             @RequestParam("balance_id") Integer balance_id) throws ParseException {
        operationsService.saveByParameters(article_id, debit, credit, timestamp, balance_id);
        ModelAndView model = new ModelAndView();
        model.setViewName("operations");
        return model;
    }

    @GetMapping("/get/byId")
    public ModelAndView getById(@RequestParam("id") Integer id) {
        ModelAndView model = new ModelAndView();
        List<Operations> list = new ArrayList<>(
                List.of(
                        operationsService.getOperationById(id)));
        model.addObject("list", list);
        model.setViewName("operationsGET");
        return model;
    }

    @GetMapping("/get/all/byArticleName")
    public ModelAndView getAllByArticleName(@RequestParam("name") String name) {
        ModelAndView model = new ModelAndView();
        List<Operations> list = operationsService.getAllByArticleName(name);
        model.addObject("list", list);
        model.setViewName("operationsGET");
        return model;
    }

    @GetMapping("/get/all/byBalanceId")
    public ModelAndView getAllByBalanceId(@RequestParam("id") Integer id) {
        ModelAndView model = new ModelAndView();
        List<Operations> list = operationsService.getAllByBalanceId(id);
        model.addObject("list", list);
        model.setViewName("operationsGET");
        return model;
    }

    @GetMapping("/get/all")
    public ModelAndView getAll() {
        ModelAndView model = new ModelAndView();
        List<Operations> list = operationsService.getAll();
        model.addObject("list", list);
        model.setViewName("operationsGET");
        return model;
    }

    @GetMapping("/put/balance_id")
    public ModelAndView putBalanceId(@RequestParam("id") Integer id, @RequestParam("balance_id") Integer balance_id) {
        operationsService.updateBalance_id(id, balance_id);
        ModelAndView model = new ModelAndView();
        model.setViewName("operations");
        return model;
    }

    @GetMapping("/delete/byId")
    public ModelAndView deleteById(@RequestParam("id") Integer id) {
        operationsService.deleteById(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("operations");
        return model;
    }

    @GetMapping("/delete/all")
    public ModelAndView deleteAll() {
        operationsService.deleteAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("operations");
        return model;
    }
}
