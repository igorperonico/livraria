package com.livraria.controllers;

import com.livraria.dtos.LivroRecordDto;
import com.livraria.models.LivroModel;
import com.livraria.repositories.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroModel>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivroById(@PathVariable(value = "id")UUID id) {
        Optional<LivroModel> livroO = livroRepository.findById(id);

        if (livroO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro nao encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(livroO.get());
        }
    }

    @PostMapping
    public ResponseEntity<LivroModel> addLivro(@RequestBody @Valid LivroRecordDto livroRecordDto) {
        LivroModel livroModel = new LivroModel();
        BeanUtils.copyProperties(livroRecordDto, livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroModel));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivro(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid LivroRecordDto livroRecordDto) {
        Optional<LivroModel> livroO = livroRepository.findById(id);
        if (livroO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro nao encontrado");
        } else {
            var livroModel = livroO.get();
            BeanUtils.copyProperties(livroRecordDto, livroModel);
            return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livroModel));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLivro(@PathVariable(value = "id") UUID id) {
        Optional<LivroModel> livroO = livroRepository.findById(id);

        if (livroO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro nao encontrado");
        } else {
            livroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Livro excluido com sucesso!");
        }
    }




}
