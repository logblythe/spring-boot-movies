package dev.sikshya.movies.repository;

import dev.sikshya.movies.pojo.GroceryItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemRepository extends MongoRepository<GroceryItem, ObjectId> {

    @Query(value = "{}",fields="{'id' : 0}")
    List<GroceryItem> findAll();
    public GroceryItem findByName(String name);

    public GroceryItem findAllByCategory(String category);
}
