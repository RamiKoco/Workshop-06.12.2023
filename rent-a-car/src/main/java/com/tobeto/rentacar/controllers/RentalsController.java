package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest){
        rentalService.update(updateRentalRequest);
    }

    @GetMapping("dto")
    public List<GetListRentalResponse>findById(@RequestParam int id){

        return rentalService.findById(id);
    }

    @GetMapping
    public List<GetListRentalResponse> findAllByOrderByIdDesc(){

        return rentalService.findAllByOrderByIdDesc();
    }
}
