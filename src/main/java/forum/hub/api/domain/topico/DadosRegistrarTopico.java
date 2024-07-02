package forum.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistrarTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String curso,
        @NotBlank
        String autor) {
}
