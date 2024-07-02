package forum.hub.api.domain.topico;

import forum.hub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="topicos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"titulo", "mensagem"})
})
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String mensagem;
    private LocalDateTime data;
    private String status;
    private String autor;
    private String curso;
    private String respostas;


    public Topico(DadosRegistrarTopico dados) {
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
        this.titulo = dados.titulo();
        this.data = LocalDateTime.now();
        this.autor = dados.autor();
        this.status = "status";
        this.respostas = "resposta";
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }

}
