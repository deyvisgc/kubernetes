package org.aguzman.springcloud.msvc.cursos.services;

import org.aguzman.springcloud.msvc.cursos.entity.Banca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class readTxtFileResourceServiceImple implements TxtFileReaderService{
    @Autowired
    private ResourceLoader resourceLoader;
    @Override
    public List<Banca> readTxtFileFromResources(String fileName, int lineasPorPagina, int paginaFinal) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        List<Banca> listBanca = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String linea;
            int numeroLinea = 0;
            int paginaActual = 1; // Página actual
            int lineasProcesadas = 0; // Número de líneas procesadas
            List<Banca> bancaPaginaActual = new ArrayList<>(); // Lista temporal para almacenar las bancas de la página actual
            while ((linea = reader.readLine()) != null && paginaActual <= paginaFinal) {
                if (numeroLinea > 0) {
                    if (paginaActual <= paginaFinal) {
                        Banca banca = new Banca();
                        List<String> list = List.of(linea.split(","));
                        banca.setId(Integer.valueOf(list.get(0)));
                        banca.setCuenta(list.get(1));
                        banca.setMonto(new BigDecimal(list.get(2)));
                        banca.setFecha(list.get(3));
                        banca.setEmpresa(list.get(4));
                        bancaPaginaActual.add(banca);
                        lineasProcesadas++;

                        if (lineasProcesadas % lineasPorPagina == 0) {
                            // Si alcanzado el final de una página, añadimos las bancas temporal a la lista de bancas
                            listBanca.addAll(bancaPaginaActual);
                            bancaPaginaActual.clear();
                            paginaActual++;
                        }
                    }
                }
                numeroLinea++;
            }
        } catch (IOException e) {
            throw new EOFException(e.getMessage());
        }
        return listBanca;
    }
}
