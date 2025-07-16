package org.punkdomus.runecraftacademy.controllers;

import lombok.RequiredArgsConstructor;
import org.punkdomus.runecraftacademy.dao.PomodoroStoryRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/pomodoro-story")
@RequiredArgsConstructor
public class PomodoroStoryController {

//    @Autowired
//    private PomodoroStoryRepository pomodoroStoryRepository;

    // PEGAR TODAS AS HISTÓRIAS DE POMODORO
    @GetMapping("/")
    public ResponseEntity getAllPomodoroStories() {
        return ResponseEntity.ok().build();
    }

    // PEGAR UMA HISTÓRIA DE POMODORO
    @GetMapping("/{pomodoroStoryId}")
    public ResponseEntity getPomodoroStoryById(@PathVariable Long pomodoroStoryId) {
        return ResponseEntity.ok().build();
    }

    // CRIAR UMA HISTORIA DE POMODORO
    @PostMapping("/{pomodoroStoryId}")
    public ResponseEntity createPomodoroStory(@PathVariable Long pomodoroStoryId, @RequestBody PomodoroStoryRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // EDITAR UMA HISTÓRIA DE POMODORO
    @PutMapping("/{pomodoroStoryId}")
    public ResponseEntity updatePomodoroStory(@PathVariable Long pomodoroStoryId, @RequestBody PomodoroStoryRequestDTO body) {
        return ResponseEntity.ok().build();
    }

}
