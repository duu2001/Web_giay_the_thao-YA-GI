package com.giay.repository;

import com.giay.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichCoRepo extends JpaRepository<KichCo,Long> {
}
