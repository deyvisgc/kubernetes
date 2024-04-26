package org.aguzman.springcloud.msvc.cursos.services;

import org.aguzman.springcloud.msvc.cursos.dto.PaginateDto;
import org.aguzman.springcloud.msvc.cursos.entity.Banca;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface TxtFileReaderService {
    PaginateDto readTxtFileFromResources(String nombreArchivo, int lineasPorPagina, int paginaFinal) throws IOException;
}
