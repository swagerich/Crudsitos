package com.erich.codeando.dto;

import com.erich.codeando.entity.Documento;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoDto {

    private Long id;

    private String code;

    private String name;

    private String description;

    private boolean state;

    public static DocumentoDto fromEntity(Documento documento) {
        if (documento == null) {
            return null;
        }

        return DocumentoDto.builder()
                .code(documento.getCode())
                .name(documento.getName())
                .description(documento.getDescription())
                .state(documento.isState())
                .build();
    }
}
