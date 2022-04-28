package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
public abstract class Conta implements ContaIm{

    private static final int AGENCIA_PADRAO = 0001;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    @Deprecated
    public Conta() {}

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }


    @Override
    public void sacar(double valor) {
        if(this.getSaldo() >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor inválido.");
        }

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void commons() {
        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d ", this.agencia));
        System.out.println(String.format("Numero: %d ", this.numero));
        System.out.println(String.format("Saldo: %2f ", this.saldo));
    }
}
