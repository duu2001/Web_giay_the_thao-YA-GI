package com.giay.repository;

import com.giay.entity.AnhSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhSanPhamRepo extends JpaRepository<AnhSanPham , Long> {
}
