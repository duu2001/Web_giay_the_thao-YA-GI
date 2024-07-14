package com.giay.dto;

import com.giay.entity.KichCo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SizeDto {
    private Long id;
    private String name;
    private int status;

    public static SizeDto fromEntity(KichCo entity) {
        return new SizeDto(
                entity.getId(),
                entity.getTen(),
                entity.getTrangthai()
        );
    }

    public static List<SizeDto> fromCollection(List<KichCo> co) {
        List<SizeDto> dtos = new ArrayList<>();
        co.forEach(c -> dtos.add(fromEntity(c)));
        return dtos;
    }

    public static List<KichCo> toEntityList(List<String> sizeNames) {
        List<KichCo> sizes = new ArrayList<>();
        sizeNames.forEach(name -> {
            KichCo kichCo = new KichCo();
            kichCo.setTen(name);
            kichCo.setTrangthai(1); // Giả sử trạng thái mặc định là 1
            sizes.add(kichCo);
        });
        return sizes;
    }
}
