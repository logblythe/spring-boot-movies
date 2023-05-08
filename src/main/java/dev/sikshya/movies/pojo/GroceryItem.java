package dev.sikshya.movies.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("grocery")
@AllArgsConstructor
@Data
public class GroceryItem {
    @Id
    private ObjectId id;
    @NotNull(message = "The name is required.")
    @NotBlank(message = "The name is required.")
    @NotEmpty(message = "The name is required")
    private String name;
    private int quantity;
    private String category;
}
