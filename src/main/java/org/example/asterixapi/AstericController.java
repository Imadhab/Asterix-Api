package org.example.asterixapi;

import org.example.asterixapi.Dto.CharactersDto;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.CharacterData;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/asterix")
public class AstericController {

    private final CharakterRepository charakterRepository;
    public AstericController(CharakterRepository charakterRepository) {
        this.charakterRepository = charakterRepository;
    }

    @GetMapping("/characters")
    public List<Character> getCharacters() {
        return charakterRepository.findAll();

    }

    @PostMapping("/characters")
    public Character createCharacter(@RequestBody CharactersDto characterDto) {
        Character character = new Character(
                UUID.randomUUID().toString(),
                characterDto.name(),
                characterDto.age(),
                characterDto.profession()
        );

        return charakterRepository.save(character);
    }
    @PostMapping("characters/all")
    public List<Character> getAllCharacters(@RequestBody List<Character> characters) {
        return charakterRepository.saveAll(characters);
    }
    @PutMapping("characters/{id}")
    public Character updateCharacter(@PathVariable String id, @RequestBody Character character) {
        Character updatedCharacter = new Character(
                id, character.name(), character.age(), character.profession()
        );
        return charakterRepository.save(updatedCharacter);
    }

    @DeleteMapping("characters/{id}")
    public void deleteCharacter(@PathVariable String id) {
        charakterRepository.deleteById(id);
    }

}
