/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michael
 */
@Controller
@RequestMapping("/Breweries")
public class BreweriesDisplay {

    @GetMapping("/All")
    public ModelAndView getAll() {
        List<Breweries> list = BrewerieService.getAllBreweries();
        return new ModelAndView("/allBrewerie", "brewerieList", list);

    }
}
