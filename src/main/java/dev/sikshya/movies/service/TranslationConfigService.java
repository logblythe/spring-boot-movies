package dev.sikshya.movies.service;

import dev.sikshya.movies.exception.CollectionException;
import dev.sikshya.movies.pojo.TranslationConfig;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
import java.util.Optional;

public interface TranslationConfigService {
    public void createTranslationConfig(TranslationConfig config) throws ConstraintViolationException, CollectionException;

    public List<TranslationConfig> findAll();

    public TranslationConfig findById(String configId) throws CollectionException;

    public TranslationConfig updateById(String configId, TranslationConfig config) throws CollectionException;

    public void deleteConfig(String configId) throws CollectionException;
}
