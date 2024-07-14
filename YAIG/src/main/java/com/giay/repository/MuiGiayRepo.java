package com.giay.repository;

import com.giay.entity.MuiGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuiGiayRepo extends JpaRepository<MuiGiay,Long> {
}
