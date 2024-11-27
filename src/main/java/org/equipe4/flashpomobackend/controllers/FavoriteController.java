package org.equipe4.flashpomobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.equipe4.flashpomobackend.dao.FavoriteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/favorite")
@RequiredArgsConstructor
public class FavoriteController {

//    @Autowired
//    private FavoriteRepository favoriteRepository;

    // PEGAR FAVORITOS
    @GetMapping("/")
    public ResponseEntity getAllFavorites() {
        return ResponseEntity.ok().build();
    }

    // PEGAR UM FAVORITO
    @GetMapping("/{favoriteId}")
    public ResponseEntity getFavoriteById(@PathVariable Long favoriteId) {
        return ResponseEntity.ok().build();
    }

    // CRIAR FAVORITO
    @PostMapping("/")
    public ResponseEntity createFavorite(@RequestBody FavoriteRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // EDITAR FAVORITOS
    @PutMapping("/{favoriteId}")
    public ResponseEntity updateFavorite(@PathVariable("favoriteId") Long favoriteId, @RequestBody FavoriteRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // DELETAR FAVORITOS
    @DeleteMapping("/{favoriteId}")
    public ResponseEntity deleteFavorite(@PathVariable("favoriteId") Long favoriteId) {
        return ResponseEntity.ok().build();
    }

}
