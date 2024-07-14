package com.giay.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giay.TrangThaiSanPham;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "sanpham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "tensanpham")
    private String tensanpham;
@Column(name = "ngaytao")
    private LocalDate ngaytao;
@Column(name = "mota")
    private String mota;
@Column(name = "sosao")
    private double sosao;
@Column(name = "soluotdanhgia")
    private int soluotdanhgia;
@Column(name = "soluong")
    private int soluong;
@Column(name = "trangthai")
    private TrangThaiSanPham trangthai;
@OneToMany(mappedBy = "sanpham")
@JsonIgnore
    private List<ChiTietSanPham> chiTietSanPhamList;
}
