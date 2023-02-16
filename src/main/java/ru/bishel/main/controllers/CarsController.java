package ru.bishel.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bishel.main.dao.CarsDAO;
import ru.bishel.main.models.Car;

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
    public String addCar(@ModelAttribute("car") Car car) {
        carsDAO.addCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/{id}/edit")
    public String editCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carsDAO.getCar(id));
        return "cars/edit";
    }
    @PatchMapping("/{id}")
    public String confirmChanges(@ModelAttribute("car") Car car, @PathVariable("id") int id) {
        carsDAO.editCar(car, id);
        return "redirect:/cars";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carsDAO.deleteCar(id);
        return "redirect:/cars";
    }
}
