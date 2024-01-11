package com.practice.Repository;

import com.practice.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends MongoRepository<User, Integer> {
}
