package com.giay.repository;

import com.giay.entity.DeGiay;
import com.sun.jdi.LongType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeGiayRepo extends JpaRepository<DeGiay, Long> {
}
