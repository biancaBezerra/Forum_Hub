package forum.hub.api.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(String titulo,
                                      String mensagem,
                                      LocalDateTime data,
                                      String status,
                                      String autor,
                                      String curso) {

    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
