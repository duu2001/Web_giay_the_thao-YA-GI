package com.giay.repository;

import com.giay.entity.LoaiSanPham;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepo extends JpaRepository<LoaiSanPham, Long> {
}
