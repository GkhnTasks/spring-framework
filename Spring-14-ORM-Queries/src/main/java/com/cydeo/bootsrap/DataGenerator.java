package com.cydeo.bootsrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository repository;

    public DataGenerator(RegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
