 package com.giay.entity;

import com.giay.TrangThaiSanPham;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "chitietsanpham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "soluong")
    private int soluong;
    @Column(name = "khoiluong")
    private int khoiluong;
    @Column(name = "gia")
    private double gia;
    @Column(name = "ngaytao")
    private LocalDateTime ngaytao;
    @Column(name = "trangthai")
    private TrangThaiSanPham trangthai;
    @Column(name = "maqr")
    private String maqr;
    @JoinColumn(name = "idthuonghieu")
    @ManyToOne
    private ThuongHieu thuonghieu;
    @JoinColumn(name = "idchatlieu")
    @ManyToOne
    private ChatLieu chatlieu;
    @JoinColumn(name = "idloaisanpham")
    @ManyToOne
    private LoaiSanPham loaisanpham;
    @JoinColumn(name = "iddegiay")
    @ManyToOne
    private DeGiay degiay;
    @JoinColumn(name = "idmuigiay")
    @ManyToOne
    private MuiGiay muigiay;
    @JoinColumn(name = "idanhsanpham")
    @ManyToOne
    private AnhSanPham anhsanpham;
    @JoinColumn(name = "idkichco")
    @ManyToOne
    private KichCo kichco;
    @JoinColumn(name = "idmausac")
    @ManyToOne
    private MauSac mausac;
    @JoinColumn(name = "idsanpham")
    @ManyToOne
    private SanPham sanpham;

}
