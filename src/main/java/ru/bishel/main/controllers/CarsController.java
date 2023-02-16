package ru.bishel.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bishel.main.dao.CarsDAO;
import ru.bishel.main.models.Car;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarsController {
    CarsDAO carsDAO;

    @Autowired
    private CarsController(CarsDAO carsDao) {
        this.carsDAO = carsDao;
    }

    @GetMapping("")
    public String mainPage(Model model) {
        model.addAttribute("cars", carsDAO.getCars());
        return "cars/cars";
    }
    @GetMapping("/{id}")
    public String carPage(@PathVariable("id") int id, Model model) {
        Car car = carsDAO.getCar(id);
        model.addAttribute("car", car);
        return "cars/carPage";
    }
    @GetMapping("/new")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "cars/newCar";
    }
    @PostMapping()
    public String addCar(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("POST BINDING HAS ERRORS");
            return "cars/newCar";
        }

        carsDAO.addCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/{id}/edit")
    public String editCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carsDAO.getCar(id));
        return "cars/edit";
    }
    @PatchMapping("/{id}")
    public String confirmChanges(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            System.out.println("PATCH BINDING HAS ERRORS");
            return "cars/edit";
        }

        carsDAO.editCar(car, id);
        return "redirect:/cars";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carsDAO.deleteCar(id);
        return "redirect:/cars";
    }
}
