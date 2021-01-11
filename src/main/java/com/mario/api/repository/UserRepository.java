package com.mario.api.repository;

import com.mario.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

     User findByFirstName(String firstName);
     User findByUserId(String userId);
     User deleteByUserId(String userId);
     User findByEmail(String email);

}
