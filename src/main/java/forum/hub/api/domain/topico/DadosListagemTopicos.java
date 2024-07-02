package forum.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(Long id,
                                   String titulo,
                                   String mensagem,
                                   LocalDateTime data,
                                   String status,
                                   String autor,
                                   String curso) {

    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
