package com.gb.lesson04;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class WordService {
    private final LibraryWords libraryWords = new LibraryWords();
    private NotificationService notificationService;

    public WordService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public List<Word> getAllWords(){
        return libraryWords.getAllWords();
    }

    public Word getWord(UUID uuid){
        return libraryWords.getWord(uuid);
    }

    public Word addWord(Word word){
        libraryWords.addWord(word);
        notificationService.notifyAddWord(word);
        return word;
    }

    public Word createWord(String name, String translation, String sentence){
        return libraryWords.createWord(name, translation, sentence);
    }

    public void deleteWord(UUID uuid){
        Word word = getWord(uuid);
        libraryWords.deleteWord(word);
        notificationService.notifyDeleteWord(word);
    }

    public Word updateWord(UUID uuid, Word wordNew){
        Word word = libraryWords.updateWord(uuid, wordNew);
        notificationService.notifyUpdateWord(word);
        return word;
    }
}
