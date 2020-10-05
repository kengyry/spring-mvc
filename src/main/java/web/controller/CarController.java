package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private Car car;

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, Model model) {

        if ((count == null) || (count > 5)) {
            count = 5;
        }

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ferrari Testarossa", "512 TR", 1992));
        cars.add(new Car("Lamborghini Gallardo", "LP550-2", 2009));
        cars.add(new Car("Maserati Quattroporte", "IV", 1994));
        cars.add(new Car("Pagani Zonda", "Cinque", 2009));
        cars.add(new Car("Жигули", "16.4", 1999));

        List<Car> temp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            temp.add(cars.get(i));
        }

        model.addAttribute("cars", temp);

        return "cars";
    }
}