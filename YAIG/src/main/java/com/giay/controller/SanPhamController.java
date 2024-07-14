package com.giay.controller;

import com.giay.TrangThaiSanPham;
import com.giay.entity.ChiTietSanPham;
import com.giay.entity.SanPham;
import com.giay.repository.ChiTietSanPhamRepo;
import com.giay.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Autowired
    SanPhamRepo sanPhamRepo;

    @GetMapping(value = "/{id}")
    public SanPham getSanPham(@PathVariable Long id) {
        return sanPhamRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/laydanhsach", method = RequestMethod.GET)
    public ResponseEntity<?> laydanhsach() throws IOException {
        return ResponseEntity.ok(sanPhamRepo.findAll());
    }
    @RequestMapping(value = "/laydschosp", method = RequestMethod.GET)
    public ResponseEntity<?> laydanhsachspc() throws IOException {
        List<SanPham> allSanPhams = sanPhamRepo.findAll();
        List<SanPham> filteredSanPhams = allSanPhams.stream()
                .filter(sanPham -> sanPham.getTrangthai().equals(TrangThaiSanPham.Chờ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredSanPhams);
    }


    @PostMapping(value = "/addsanpham")
    public SanPham create(@RequestBody SanPham sanPham) {
        sanPham.setNgaytao(LocalDate.now());
        sanPham.setSoluotdanhgia(0);
        sanPham.setSosao(1);
        sanPham.setTrangthai(TrangThaiSanPham.Chờ);
        return sanPhamRepo.save(sanPham);
    }
    @PutMapping(value = "/updatesanpham/{id}")
    public ResponseEntity<SanPham> update( @RequestBody SanPham nSanPham,@PathVariable Long id) {
        Optional<SanPham> OP = sanPhamRepo.findById(id);
        if (OP.isPresent()) {
            SanPham oSanPham = OP.get();
            oSanPham.setTensanpham(nSanPham.getTensanpham());
            sanPhamRepo.save(oSanPham);

            return new ResponseEntity<>(oSanPham, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}

    @PatchMapping("/change/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<SanPham> sP = sanPhamRepo.findById(id);
        System.out.println(sP.get().getId());
        if (sP.isPresent()) {
            SanPham existingSanPham = sP.get();

            if (existingSanPham.getTrangthai().equals(TrangThaiSanPham.ĐangBán)) {
                existingSanPham.setTrangthai(TrangThaiSanPham.Ngưng);
                sanPhamRepo.save(existingSanPham);

                return new ResponseEntity<>(existingSanPham, HttpStatus.OK);
            }
        }
            return new ResponseEntity<>("SanPham not found", HttpStatus.NOT_FOUND);


    }
    }
