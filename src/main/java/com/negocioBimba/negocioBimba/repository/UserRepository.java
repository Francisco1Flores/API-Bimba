package com.negocioBimba.negocioBimba.repository;

import com.negocioBimba.negocioBimba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByDeletionDateNull();
}
