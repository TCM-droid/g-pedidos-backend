package com.un.Gpedidos.relatorios.services;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class RelatoriosService {

    private final DataSource dataSource;
    
    public RelatoriosService(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    public byte[] exportarRelatorioDatas(LocalDate dataInicio, LocalDate dataFim) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            InputStream reportStream = getClass().getResourceAsStream("/reports/report_intervalo_datas.jrxml");
            String string = new String(reportStream.readAllBytes(), StandardCharsets.UTF_8);
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
            Map<String, Object> params = new HashMap<>();
            params.put("dataInicio", java.sql.Date.valueOf(dataInicio));
            params.put("dataFim", java.sql.Date.valueOf(dataFim));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        }catch (Exception e) {
        	System.out.println(e);
        	return null;
		}
    }
    
}
