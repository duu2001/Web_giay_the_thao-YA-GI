package com.giay.controller;

import com.giay.TrangThaiSanPham;
import com.giay.dto.ColorRequestIDDto;
import com.giay.dto.SizeDto;
import com.giay.dto.SizeRequestIDDto;
import com.giay.entity.*;
import com.giay.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/chitietsanpham")
public class ChiTietSanPhamController {
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;
    @Autowired
    ChatLieuRepo chatLieuRepo;
    @Autowired
    ThuongHieuRepo thuongHieuRepo;
    @Autowired
    LoaiSanPhamRepo loaiSanPhamRepo;
    @Autowired
    MuiGiayRepo muiGiayRepo;
    @Autowired
    DeGiayRepo deGiayRepo;
    @Autowired
    KichCoRepo kichCoRepo;
    @Autowired
    MauSacRepo mauSacRepo;
    @Autowired
    private SanPhamRepo sanPhamRepo;


    @RequestMapping(value = "/laydschatlieu" , method = RequestMethod.GET)
    public ResponseEntity<?> laydschatlieu() throws IOException {
        return ResponseEntity.ok(chatLieuRepo.findAll());
    }
    @RequestMapping(value = "/laydsthuonghieu" , method = RequestMethod.GET)
    public ResponseEntity<?> laydsthuonghieu() throws IOException {
        return ResponseEntity.ok(thuongHieuRepo.findAll());
    }
    @RequestMapping(value = "/laydsloaisp" , method = RequestMethod.GET)
    public ResponseEntity<?> laydsloai() throws IOException {
        return ResponseEntity.ok(loaiSanPhamRepo.findAll());
    }
    @RequestMapping(value = "/laydsmuigy" , method = RequestMethod.GET)
    public ResponseEntity<?> laydsmuigi() throws IOException {
        return ResponseEntity.ok(muiGiayRepo.findAll());
    }
    @RequestMapping(value = "/laydsdegiay" , method = RequestMethod.GET)
    public ResponseEntity<?> laydsdegiay() throws IOException {
        return ResponseEntity.ok(deGiayRepo.findAll());
    }@RequestMapping(value = "/laydssize" , method = RequestMethod.GET)
    public ResponseEntity<?> laydssize() throws IOException {
        return ResponseEntity.ok(kichCoRepo.findAll());
    }@RequestMapping(value = "/laydscolors" , method = RequestMethod.GET)
    public ResponseEntity<?> laydscolores() throws IOException {
        return ResponseEntity.ok(mauSacRepo.findAll());
    }

    @GetMapping(value = "/{id}")
    public ChiTietSanPham getChiTietSanPham(@PathVariable Long id) {
        return chiTietSanPhamRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/laydanhsach", method = RequestMethod.GET)
    public ResponseEntity<?> laydanhsach() throws IOException {
        return ResponseEntity.ok(chiTietSanPhamRepo.findAll());
    }
    @PostMapping("/addsize/{idsanpham}/{idchatlieu}/{idthuonghieu}/{idloaisanpham}/{idmuigiay}/{iddegiay}")
    public void  addSizes(@RequestBody SizeRequestIDDto sizeRequestIDDto,
//                          @RequestBody ColorRequestIDDto colorRequestIDDto,
                          @PathVariable Long idsanpham ,
                          @PathVariable Long idchatlieu,
                          @PathVariable Long idthuonghieu,
                          @PathVariable Long idloaisanpham,
                          @PathVariable Long idmuigiay,
                          @PathVariable Long iddegiay
    ) {
        List<Long> sizeIds = sizeRequestIDDto.getSizeIds();
//        List<Long> colorIds = colorRequestIDDto.getColorIds();
        System.out.println("Size IDs to add: " + sizeIds);
//        System.out.println("Color IDs to add: " + colorIds);
        System.out.println("chat lieu id: " + idchatlieu);
        Optional<SanPham> sanPham = sanPhamRepo.findById(idsanpham);
        Optional<ChatLieu> chatLieu = chatLieuRepo.findById(idchatlieu);
        Optional<ThuongHieu> thuongHieu = thuongHieuRepo.findById(idthuonghieu);
        Optional<LoaiSanPham> loaiSanPham = loaiSanPhamRepo.findById(idloaisanpham);
        Optional<DeGiay> deGiay = deGiayRepo.findById(idmuigiay);
        Optional<MuiGiay> muiGiay = muiGiayRepo.findById(iddegiay);
        List<KichCo> kichCos = kichCoRepo.findAllById(sizeIds);
        List<MauSac> mausacs = mauSacRepo.findAllById(sizeIds);

        for(KichCo kc : kichCos){
            System.out.println( "KichCo: " + kc.getTen() + "id: " + kc.getId() + " trang thái: " + kc.getTrangthai()  );
            for(MauSac ms : mausacs){

            //Thêm chitiet
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
                chiTietSanPham.setSanpham(sanPham.get());
            chiTietSanPham.setChatlieu(chatLieu.get());
            chiTietSanPham.setThuonghieu(thuongHieu.get());
            chiTietSanPham.setLoaisanpham(loaiSanPham.get());
            chiTietSanPham.setDegiay(deGiay.get());
            chiTietSanPham.setMuigiay(muiGiay.get());
            chiTietSanPham.setNgaytao(LocalDateTime.now());
            chiTietSanPham.setTrangthai(TrangThaiSanPham.Chờ);
            chiTietSanPham.setKichco(kc);
            chiTietSanPham.setMausac(ms);
            chiTietSanPhamRepo.save(chiTietSanPham);
        }
        }


    }



//    @PostMapping(value = "/addctsp")
//    public ChiTietSanPham create(@RequestBody ChiTietSanPham chiTietSanPham) {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder randomPart = new StringBuilder();
//        chiTietSanPham.setMaqr("SP"+randomPart.toString());
//        chiTietSanPham.setNgaytao(LocalDateTime.now());
//        chiTietSanPham.setTrangthai(TrangThaiSanPham.Chờ);
//        chiTietSanPham.getChatlieu();
//        return chiTietSanPhamRepo.save(chiTietSanPham);
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ChiTietSanPham> update(@RequestBody ChiTietSanPham nchiTietSanPham, @PathVariable Long id) {


        Optional<ChiTietSanPham> ODP = chiTietSanPhamRepo.findById(id);
        if (ODP.isPresent()) {
            ChiTietSanPham oldChiTietSanPham = ODP.get();
            oldChiTietSanPham.setThuonghieu(nchiTietSanPham.getThuonghieu());
            oldChiTietSanPham.setMaqr(nchiTietSanPham.getMaqr());
            oldChiTietSanPham.setGia(nchiTietSanPham.getGia());
            oldChiTietSanPham.setDegiay(nchiTietSanPham.getDegiay());
            oldChiTietSanPham.setMausac(nchiTietSanPham.getMausac());
            oldChiTietSanPham.setKichco(nchiTietSanPham.getKichco());
            oldChiTietSanPham.setMuigiay(nchiTietSanPham.getMuigiay());
            oldChiTietSanPham.setKhoiluong(nchiTietSanPham.getKhoiluong());
            chiTietSanPhamRepo.save(oldChiTietSanPham);
            return new ResponseEntity<>(oldChiTietSanPham, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/change/{id}")
    public ResponseEntity<?> thaydoitrangthai(@PathVariable Long id) {
        Optional<ChiTietSanPham> chiTietSanPham = chiTietSanPhamRepo.findById(id);
        System.out.println(chiTietSanPham.get().getTrangthai());
        if (chiTietSanPham.isPresent()) {
            ChiTietSanPham dP = chiTietSanPham.get();
            if (dP.getTrangthai().equals(TrangThaiSanPham.ĐangBán)) {
                dP.setTrangthai(TrangThaiSanPham.Ngưng);
                chiTietSanPhamRepo.save(dP);
            }
//            else if (dP.getTrangthai() == 2) {
//                dP.setTrangthai(1);
//                chiTietSanPhamRepo.save(dP);
//            }
        }
//return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(chiTietSanPhamRepo.findById(id));
    }
}
