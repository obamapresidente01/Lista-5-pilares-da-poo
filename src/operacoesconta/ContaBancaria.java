package operacoesconta;

public class ContaBancaria implements OperacoesConta {
    private double saldo;
    protected String numeroConta;

    public ContaBancaria(double saldo, String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        if (saldoInicial < 0) {
            System.out.println("Saldo inicial nao pode ser negativo");
            this.saldo = 0;
        } else {
            this.saldo = saldoInicial;
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0){
            saldo += valor;
            System.out.println("Deposito de: R$ " + valor + " Realizado com sucesso");
        } else {
            System.out.println("Valor invalido");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0){
            System.out.println("Valor de saque invalido");
        } else if (valor > saldo){
            System.out.println("Saldo insuficiente para transferir");
        } else {
            saldo -= valor;
            System.out.println("Saque de: R$ " + valor + " Realizado com sucesso");
        }
    }


    @Override
    public double consultarSaldo() {
        return saldo;
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= 0){
            System.out.println("Valor invalido");
        } else if (valor > saldo){
            System.out.println("Saldo insuficiente para transferir");
        } else {
            this.sacar(valor);
            contaDestino.sacar(valor);
            System.out.println("Saldo transferido: R$ " + valor + " Realizado com sucesso");

        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
