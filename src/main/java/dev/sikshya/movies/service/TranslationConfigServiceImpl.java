package dev.sikshya.movies.service;

import dev.sikshya.movies.exception.CollectionException;
import dev.sikshya.movies.pojo.TranslationConfig;
import dev.sikshya.movies.repository.TranslationConfigRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationConfigServiceImpl implements TranslationConfigService {

    @Autowired
    TranslationConfigRepository repository;

    @Override
    public void createTranslationConfig(TranslationConfig config) throws ConstraintViolationException, CollectionException {
        Optional<TranslationConfig> configOptional = repository.findByProjectName(config.getProjectName());
        if (configOptional.isPresent()) {
            throw new CollectionException(CollectionException.AlreadyExistsException());
        } else {
            repository.save(config);
        }

    }

    @Override
    public List<TranslationConfig> findAll() {
        return repository.findAll();
    }

    @Override
    public TranslationConfig findById(String configId) throws CollectionException {
        Optional<TranslationConfig> translationConfig = repository.findById(configId);
        if (translationConfig.isPresent()) {
            return translationConfig.get();
        } else {
            throw new CollectionException(CollectionException.NotFoundException(configId));
        }
    }

    @Override
    public TranslationConfig updateById(String configId, TranslationConfig config) throws CollectionException {
        Optional<TranslationConfig> existingConfig = repository.findById(configId);
        if (existingConfig.isPresent()) {
            return repository.save(config);
        } else {
            throw new CollectionException(CollectionException.NotFoundException(configId));
        }
    }

    @Override
    public void deleteConfig(String configId) throws CollectionException {
        Optional<TranslationConfig> existingConfig = repository.findById(configId);
        if (existingConfig.isPresent()) {
            repository.deleteById(configId);
        } else {
            throw new CollectionException(CollectionException.NotFoundException(configId));
        }
    }


}
