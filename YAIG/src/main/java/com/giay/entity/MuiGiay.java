package com.giay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "muigiay")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuiGiay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "trangthai")
    private int trangthai;
    @OneToMany (mappedBy = "muigiay")
    @JsonIgnore
    private List<ChiTietSanPham> chiTietSanPhams;
}
