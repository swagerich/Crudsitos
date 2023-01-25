package com.erich.codeando.dto;

import com.erich.codeando.entity.Contribuyente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContribuyenteDto {

    private Long id;

    private String name;

    private boolean state;

    public static DocumentoDto fromEntity(Contribuyente contribuyente) {
        if (contribuyente == null) {
            return null;
        }

        return DocumentoDto.builder()
                .name(contribuyente.getName())
                .state(contribuyente.isState())
                .build();
    }
}
