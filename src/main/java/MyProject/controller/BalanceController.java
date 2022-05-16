package MyProject.controller;

import MyProject.entities.Balance;
import MyProject.services.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private BalanceService balanceService;

    @Autowired
    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("")
    public ModelAndView start() {
        ModelAndView model = new ModelAndView();
        model.setViewName("balance");
        return model;
    }

    @GetMapping("/save")
    public ModelAndView addArticles(@RequestParam("timestamp") String timestamp) throws ParseException {
        balanceService.saveByParameters(timestamp);
        ModelAndView model = new ModelAndView();
        model.setViewName("balance");
        return model;
    }

    @GetMapping("/get/byId")
    public ModelAndView getById(@RequestParam("id") Integer id) {
        ModelAndView model = new ModelAndView();
        List<Balance> list = new ArrayList<>(
                List.of(
                        balanceService.getById(id)));
        model.addObject("list", list);
        model.setViewName("balanceGET");
        return model;
    }

    @GetMapping("/get/byCreateDate")
    public ModelAndView getByCreateDate(@RequestParam("timestamp") String timestamp) throws ParseException {
        ModelAndView model = new ModelAndView();
        List<Balance> list = balanceService.getAllByCreateDate(timestamp);
        model.addObject("list", list);
        model.setViewName("balanceGET");
        return model;
    }

    @GetMapping("/get/all")
    public ModelAndView getAll() {
        ModelAndView model = new ModelAndView();
        List<Balance> list = balanceService.getAll();
        model.addObject("list", list);
        model.setViewName("balanceGET");
        return model;
    }

    @GetMapping("/delete/byId")
    public ModelAndView deleteById(@RequestParam("id") Integer id) {
        balanceService.deleteById(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("balance");
        return model;
    }

    @GetMapping("/delete/all/byCreateDate")
    public ModelAndView deleteAllByCreateDate(String timestamp) throws ParseException {
        balanceService.deleteAllByCreateDate(timestamp);
        ModelAndView model = new ModelAndView();
        model.setViewName("balance");
        return model;
    }

    @GetMapping("/delete/all")
    public ModelAndView deleteAll() {
        balanceService.deleteAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("balance");
        return model;
    }
}
