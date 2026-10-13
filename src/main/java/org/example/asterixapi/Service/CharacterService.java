package org.example.asterixapi.Service;

import org.example.asterixapi.Character;
import org.example.asterixapi.CharakterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharakterRepository repository;
    public CharacterService(CharakterRepository repository) {
        this.repository = repository;
    }
    public List<Character> fidAllCharacters() {
        return repository.findAll();
    }
    public Optional<Character> findById (String id) {
        return repository.findById(id);
    }
}
