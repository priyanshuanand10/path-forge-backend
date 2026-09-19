package com.pathforge.backend.service;

import com.pathforge.backend.entity.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tomcat.util.http.parser.TE;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UploadService {

    private final ChatService chatService;

    public Response processPdf(MultipartFile file, String role, String days) throws IOException {
        System.out.println("Role: " + role);
        System.out.println("Days: " + days);
        String text = "";
        try (PDDocument document = Loader.loadPDF(new RandomAccessReadBuffer(file.getInputStream()))) {
            PDFTextStripper stripper = new PDFTextStripper();
             text = stripper.getText(document);
            System.out.println("PDF Content:");
            System.out.println(text);
        }

        return chatService.getChatResponseV2(text , role , days);


    }
}
