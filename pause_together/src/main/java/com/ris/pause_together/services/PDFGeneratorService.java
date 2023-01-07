package com.ris.pause_together.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URL;


@Service
public class PDFGeneratorService {
    public void ustvariPDF(String pot, HttpServletResponse res) throws IOException {
        try{
            /*
            delo z itexpdf
            absolutna pot - ni idealno
            Path pot = Path.of("");
            Image img = Image.getInstance(pot.toAbsolutePath().toString());
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("dodanaslika.pdf"));
            doc.open();
            doc.add(img);
            doc.close();
            */
            URL imgUrl = new URL(pot);
            Document doc = new Document();
            PdfWriter.getInstance(doc, res.getOutputStream());
            doc.open();
            Image img = Image.getInstance(imgUrl);
            doc.add(img);
            doc.close();

        } catch (BadElementException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        /*
        catch (DocumentException e2){
        }

         */
    }
}
