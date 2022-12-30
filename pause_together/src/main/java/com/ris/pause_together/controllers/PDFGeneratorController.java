package com.ris.pause_together.controllers;

import com.ris.pause_together.services.PDFGeneratorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/generiraj")
public class PDFGeneratorController {

    private final PDFGeneratorService pdfGeneratorService;

    public PDFGeneratorController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }
    @GetMapping
    public void generirajPDF(@RequestParam("url") String pot, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String trenutniCas = dFormat.format(new Date());
        String hKey = "Content-Disposition";
        String hValue = "attachment; filaname=slika_" + trenutniCas + ".pdf";
        response.setHeader(hKey, hValue);
        pdfGeneratorService.ustvariPDF(pot, response);
    }
}
