package org.punkdomus.runecraftacademy.data.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteId implements Serializable {

    private UUID userId;
    private UUID ensembleId;

}
