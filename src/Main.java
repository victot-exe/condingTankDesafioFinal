import Funcoes.Funcoes;

public class Main {

    public static void main(String[] args) {

        Funcoes funcoes = new Funcoes();

        double totalSaldoDevedor = 0;
        double jurosMensal = 0;
        //Deixei o total de mezes em double para poder utilizar a mesma função que utilizo para solicitar os dados
        double totalDeMeses = 0;

        totalSaldoDevedor = funcoes.pedirDados("valor do empréstimo", totalSaldoDevedor);
        jurosMensal = funcoes.pedirDados("taxa de juros do emprestimo", jurosMensal);
        totalDeMeses = funcoes.pedirDados("Tempo para pagamento (em meses)", totalDeMeses);

        funcoes.exibirDadosDasParcelas(totalSaldoDevedor, jurosMensal, totalDeMeses);

    }
}
