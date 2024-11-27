package org.equipe4.flashpomobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.equipe4.flashpomobackend.dao.PurchaseRequestDTO;
import org.equipe4.flashpomobackend.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/purchase")
@RequiredArgsConstructor
public class PurschaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    // PEGAR TODAS AS COMPRAS
    @GetMapping("/")
    public ResponseEntity getAllPurchases() {
        return ResponseEntity.ok().build();
    }

    // PEGAR UMA COMPRA
    @GetMapping("/{purchaseId}")
    public ResponseEntity getPurchaseById(@PathVariable Long purchaseId) {
        return ResponseEntity.ok().build();
    }

    // CRIAR UMA COMPRA
    @PostMapping("/{purchaseId}")
    public ResponseEntity createPurchase(@PathVariable Long purchaseId, @RequestBody PurchaseRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // EDITAR UMA COMPRA
    @PutMapping("/{purchaseId}")
    public ResponseEntity updatePurchase(@PathVariable Long purchaseId, @RequestBody PurchaseRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // DELETAR UMA COMPRA
    @DeleteMapping("/{purchaseId}")
    public ResponseEntity deletePurchase(@PathVariable Long purchaseId) {
        return ResponseEntity.ok().build();
    }

}
