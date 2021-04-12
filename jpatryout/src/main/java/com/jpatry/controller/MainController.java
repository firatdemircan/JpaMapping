package com.jpatry.controller;

import com.jpatry.models.City;
import com.jpatry.models.Guest;
import com.jpatry.models.Product;
import com.jpatry.repostory.CityRepostory;
import com.jpatry.repostory.GuestRepostory;
import com.jpatry.repostory.ProductRepostory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    ProductRepostory productRepostory;
    GuestRepostory guestRepostory;
    CityRepostory cityRepostory;

    public MainController(com.jpatry.repostory.ProductRepostory productRepostory, GuestRepostory guestRepostory, CityRepostory cityRepostory) {
        this.productRepostory = productRepostory;
        this.guestRepostory = guestRepostory;
        this.cityRepostory = cityRepostory;
    }


    @PostMapping("/insertcity")
    public ResponseEntity<Object> insert(@RequestBody City city){
       City c = cityRepostory.save(city);

       return new ResponseEntity<Object>(c, HttpStatus.OK);
    }

    @PostMapping("/insertguest")
    public ResponseEntity<Object> insert(@RequestBody Guest guest){
        Guest c = guestRepostory.save(guest);

        return new ResponseEntity<Object>(c, HttpStatus.OK);
    }

    @PostMapping("/insertproduct")
    public ResponseEntity<Object> insert(@RequestBody Product product){
        Guest guest = guestRepostory.getOne(product.getGuest().getId());
        product.setGuest(guest);

        Product p = productRepostory.save(product);

        return new ResponseEntity<Object>(p, HttpStatus.OK);
    }

    @GetMapping("/listproduct")
    public ResponseEntity<Object> listproduct(){
        List<Product> c = productRepostory.findAll();

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/listguest")
    public ResponseEntity<Object> listguest(){
        List<Guest> c = guestRepostory.findAll();

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/listcities")
    public ResponseEntity<Object> listcities(){
        List<City> c = cityRepostory.finAllW();

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}





