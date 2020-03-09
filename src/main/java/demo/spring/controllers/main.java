/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author danie
 */
@RestController
@RequestMapping("/home")
public class main {

    @Autowired
    AgentService agentService;

    @RequestMapping("/displayAll")
    public ModelAndView diplayAllAgents() {
        return new ModelAndView("/allBrewerie", "brewerieList", agentService.getAllAgents());
    }

    @GetMapping("/add")
    public ModelAndView displayAgentAddForm() {
        return new ModelAndView("/addAgent", "agent", new Agent());
    }

    @PostMapping("/addAgent")
    public ModelAndView addAnAgent(@Valid @ModelAttribute("agent") Agent agent, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("/addAgent");
        }
        agentService.addAnAgent(agent);
        return new ModelAndView("redirect:/home/displayAll");
    }
//    
    @RequestMapping("/edit")
    public ModelAndView editAgentForm(@QueryParam("id") int id) {
        return new ModelAndView("/editAgent", "agent", agentService.getAgentById(id));
    }
    
    @PostMapping("/editAgent")
    public ModelAndView editAgent(@Valid @ModelAttribute("agent") Agent agent, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("/editAgent");
        }
        agentService.editAgent(agent);
        return new ModelAndView("redirect:/home/displayAll");
    }

    @GetMapping("/delete")
    public ModelAndView deleteAnAgent(@QueryParam("id") int id) {
        agentService.deleteAnAgent(id);
        return new ModelAndView("redirect:/home/displayAll");
    }

}
