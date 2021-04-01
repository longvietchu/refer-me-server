package com.hust.referme.domain.repository;

import com.hust.referme.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUsersByEmail(String email);
}
