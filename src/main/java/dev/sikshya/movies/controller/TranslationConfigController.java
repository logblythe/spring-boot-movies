package dev.sikshya.movies.controller;

import dev.sikshya.movies.exception.CollectionException;
import dev.sikshya.movies.pojo.TranslationConfig;
import dev.sikshya.movies.service.TranslationConfigService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/translation-config")
public class TranslationConfigController {
    @Autowired
    private TranslationConfigService service;

    @GetMapping()
    public ResponseEntity<?> getTranslationConfig() {
        List<TranslationConfig> configs = service.findAll();
        return ResponseEntity.ok(configs);
    }

    @GetMapping("/{configId}")
    public ResponseEntity<?> getTranslationConfigById(@PathVariable(required = false) String configId) {
        try {
            TranslationConfig config = service.findById(configId);
            return ResponseEntity.ok(config);
        } catch (CollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveTranslationConfig(@RequestBody TranslationConfig config) {
        try {
            service.createTranslationConfig(config);
            return ResponseEntity.status(HttpStatus.OK).body(config);
        } catch (CollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{configId}")
    public ResponseEntity<?> updateTranslationConfig(@PathVariable String configId, @RequestBody TranslationConfig config) {
        try {
            TranslationConfig updatedConfig = service.updateById(configId, config);
            return ResponseEntity.ok(updatedConfig);
        } catch (CollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{configId}")
    public ResponseEntity<?> deleteTranslationConfig(@PathVariable String configId) {
        try {
            service.deleteConfig(configId);
            return ResponseEntity.ok("Deleted");
        } catch (CollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
