package com.example.demo.modelo.dto.requisicao;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class OperadorIdDto {

    @NotNull(message = "O id no usuário não pode ser nulo ou vazio!")
    private UUID id;

    @Override
    public String toString() {
        return "id=" + id;
    }
}
