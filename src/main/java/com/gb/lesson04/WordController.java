package com.gb.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public String getAllTask(Model model){
        model.addAttribute("words", wordService.getAllWords());
        return "words";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id, Model model){
        model.addAttribute("word", wordService.getWord(id));
        return "word";
    }
}
