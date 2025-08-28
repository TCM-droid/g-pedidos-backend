package com.un.Gpedidos.relatorios.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.un.Gpedidos.relatorios.services.RelatoriosService;

@RestController
@RequestMapping("/api/relatorios")
public class RelatoriosController {

	@Autowired
	RelatoriosService relatoriosService;
	
	@GetMapping("/entredatas")
    public ResponseEntity<byte[]> generatePdf() throws Exception {
        byte[] pdf = relatoriosService.exportarRelatorioDatas(LocalDate.of(2025, 8, 14), LocalDate.of(2025, 8, 27));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=pedidos_entre_datas.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
