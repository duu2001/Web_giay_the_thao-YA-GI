package com.giay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "anhsanpham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnhSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "duongdan")
    private String duongdan;
    @Column(name = "trangthai")
    private int trangthai;
    @OneToMany (mappedBy = "anhsanpham")
    @JsonIgnore
    private List<ChiTietSanPham> chiTietSanPhamList;

}
