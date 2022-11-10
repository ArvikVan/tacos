package com.example.tacos.repo;

import com.example.tacos.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcIngredientRepository implements IngredientRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
