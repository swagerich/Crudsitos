package com.erich.codeando.dto;


import com.erich.codeando.entity.Entidad;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntidadDto {

    private Long id;

    private String nroDocumento;

    private String razonSocial;

    private String nombreComercial;

    private String direccion;

    private Integer telefono;

    private boolean state;

    public static EntidadDto fromEntity(Entidad entidad) {
        if (entidad == null) {
            return null;
        }

        return EntidadDto.builder()
                .nroDocumento(entidad.getNroDocumento())
                .razonSocial(entidad.getRazonSocial())
                .nombreComercial(entidad.getNombreComercial())
                .state(entidad.isState())
                .build();
    }
}
