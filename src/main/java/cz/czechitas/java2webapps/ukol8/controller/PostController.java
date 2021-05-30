package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznamPostu() {
        ModelAndView seznam = new ModelAndView("index");
        seznam.addObject("seznam", service.list());
        return seznam;
    }

    @GetMapping("/post/{slug}")
    public ModelAndView clanek(@PathVariable String slug) {
        ModelAndView seznam = new ModelAndView("clanek");
        seznam.addObject("seznam", service.singlePost(slug));
        return seznam;
    }

}
