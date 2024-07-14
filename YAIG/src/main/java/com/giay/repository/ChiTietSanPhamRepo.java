package com.giay.repository;

import com.giay.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, Long> {

}
