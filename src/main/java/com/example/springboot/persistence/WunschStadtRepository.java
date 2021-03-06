package com.example.springboot.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WunschStadtRepository extends JpaRepository<WunschStadtEntity, Long> {

}
