package dev.sikshya.movies.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("translation-config")
@AllArgsConstructor
@Data
public class TranslationConfig {
    @Id
    private String id;
    @NotNull(message = "Resource type is required")
    private String resourceType;
    @NotNull(message = "Resource ids is required")
    private List<String> resourceIds;
    @NotNull(message = "Fields is required")
    private List<String> fields;
    @NotNull(message = "Target languages is required")
    private List<String> targetLanguages;
    @NotNull(message = "Project name is required")
    private String projectName;
    private String notes;
}
