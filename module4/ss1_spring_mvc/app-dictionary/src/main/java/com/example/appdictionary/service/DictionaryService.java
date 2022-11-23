package com.example.appdictionary.service;

import com.example.appdictionary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    public String convert(String input) {
        return dictionaryRepository.convert(input);
    }
}
