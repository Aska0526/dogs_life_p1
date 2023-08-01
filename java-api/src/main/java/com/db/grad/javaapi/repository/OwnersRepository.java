package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnersRepository extends JpaRepository<Owner, Integer> {

    Owner findById(long id);
}
