package dev.sikshya.movies.service;

import dev.sikshya.movies.pojo.GroceryItem;
import dev.sikshya.movies.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {
    @Autowired
    private GroceryItemRepository repository;

    public List<GroceryItem> showAllGroceryItems(){
       return repository.findAll();
    }

    public GroceryItem getGroceryItemByName(String name){
        return repository.findByName(name);
    }

    public GroceryItem getItemsByCategory(String category){
        return repository.findAllByCategory(category);
    }

    public long findCountOfGroceryItems(){
        return repository.count();
    }

    public GroceryItem save(GroceryItem groceryItem){
        return repository.save(groceryItem);
    }


}
