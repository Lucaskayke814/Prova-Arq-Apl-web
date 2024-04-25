package com.example.ProvaArq.repository;

import com.example.ProvaArq.ibgeEntity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ibgeRepository extends MongoRepository<Entity, String>{
}
