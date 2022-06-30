package com.example.ormabackendtest.repositories;

import com.example.ormabackendtest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByToken(Long token);
}
