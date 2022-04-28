package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter @Setter
public class Banco {

    private String nome;
    private List<Conta> contas;

}
