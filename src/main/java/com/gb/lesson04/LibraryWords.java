package com.gb.lesson04;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LibraryWords {
    private List<Word> words = new ArrayList<>();


    public List<Word> getAllWords(){
        createWord("word", "слово", "You give me your word");
        createWord("keep", "держать, хранить", "keep your word");
        createWord("give", "Давать", "Give me the bottle with wine, Pilar");
        return words;
    }

    public Word getWord(UUID uuid){
        return words.stream().filter(t ->t.getId().equals(uuid)).findFirst().orElse(null);
    }

    public Word addWord(Word word){
        words.add(word);
        return word;
    }

    public Word createWord(String name, String translation, String sentence){
        Word word = new Word(name, translation, sentence);
        return addWord(word);
    }

    public void deleteWord(Word word){
        words.remove(word);
    }

    public Word updateWord(UUID uuid, Word wordNew){
        Word word1 = getWord(uuid);
        if(word1 != null){
            word1.setDescription(wordNew.getDescription());
            word1.setName(wordNew.getName());
            word1.setSentence(wordNew.getSentence());
            word1.setTranslation(wordNew.getTranslation());
            word1.setStatus(wordNew.getStatus());
        }
        return word1;
    }

}
