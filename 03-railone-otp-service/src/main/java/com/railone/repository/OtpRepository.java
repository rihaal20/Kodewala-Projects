package com.railone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.railone.entity.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Integer>{

}
