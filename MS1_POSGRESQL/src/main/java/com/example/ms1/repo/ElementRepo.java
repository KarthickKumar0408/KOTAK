package com.example.ms1.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.ms1.model.Element;

public interface ElementRepo extends CrudRepository<Element, Integer> {

}
