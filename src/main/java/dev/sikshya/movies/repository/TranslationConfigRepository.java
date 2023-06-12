package dev.sikshya.movies.repository;

import dev.sikshya.movies.pojo.TranslationConfig;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TranslationConfigRepository extends MongoRepository<TranslationConfig, String> {

    @NotNull
    public List<TranslationConfig> findAll();

    @Query("{projectName:?0}")
    Optional<TranslationConfig> findByProjectName(String projectName);
}
