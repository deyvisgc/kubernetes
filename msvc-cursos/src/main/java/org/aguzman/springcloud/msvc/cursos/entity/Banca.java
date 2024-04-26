package org.aguzman.springcloud.msvc.cursos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banca {
    private int id;
    private String fecha;
    private  String cuenta;
    private String empresa;
    private BigDecimal monto;
}
