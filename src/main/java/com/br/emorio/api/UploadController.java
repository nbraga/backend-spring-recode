package com.br.emorio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.emorio.services.UploadService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UploadController {

  @Autowired
  UploadService storageService;

  @PostMapping("/upload")
  @CrossOrigin("*")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      storageService.save(file);

      return ResponseEntity.status(HttpStatus.OK).body(file.getOriginalFilename());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Falha ao enviar a imagem");
    }
  }

  @GetMapping("/files/{filename:.+}")
  @ResponseBody
  @CrossOrigin("*")
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }
}
