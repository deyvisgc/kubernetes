package org.aguzman.springcloud.msvc.cursos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aguzman.springcloud.msvc.cursos.entity.Banca;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginateDto {
    int totalRegistros;
    List<Banca> bancas;
    int pagina;
    int limit;
}
