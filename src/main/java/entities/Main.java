package entities;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Anne");
        System.out.println(cliente.getNome());
        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);
        cc.depositar(300);
        cc.sacar(100);
        cc.transferir(100,cp);
        cp.imprimirExtrato();
        cc.imprimirExtrato();
    }
}
