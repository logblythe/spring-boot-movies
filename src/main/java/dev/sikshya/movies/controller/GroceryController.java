package dev.sikshya.movies.controller;

import dev.sikshya.movies.pojo.GroceryItem;
import dev.sikshya.movies.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grocery")

public class GroceryController {
    @Autowired
    GroceryService groceryService;

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        return new ResponseEntity<>(groceryService.showAllGroceryItems(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<GroceryItem> getGroceryByName(@PathVariable String name) {
        return new ResponseEntity<>(groceryService.getGroceryItemByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroceryItem> saveGrocery(@RequestBody GroceryItem groceryItem) {
        return new ResponseEntity<>(groceryService.save(groceryItem), HttpStatus.CREATED);
    }
}
