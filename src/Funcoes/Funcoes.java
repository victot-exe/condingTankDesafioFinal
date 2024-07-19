package Funcoes;

import java.util.Scanner;

public class Funcoes {

    Scanner scanner = new Scanner(System.in);

    public double pedirDados(String valorSolicitado, double valor)
    {
        System.out.println("Informe o/a : " + valorSolicitado);
        valor = Double.parseDouble(scanner.nextLine());

        return valor;
    }

    public double calculaAmortizacao(double saldoDevedor, double totalMeses)
    {
        return saldoDevedor / totalMeses;
    }

    public double calculaJurosMensal(double saldoDevedorAtual, double jurosAoMes)
    {
        return saldoDevedorAtual * jurosAoMes;
    }

    public double calculaParcelaMensal(double amortizacao, double jurosMensal)
    {
        return amortizacao + jurosMensal;
    }

    public double calculaSaldoDevedor(double saldoDevedorAtual, double amortizacao)
    {
        return saldoDevedorAtual - amortizacao;
    }

    public void exibirDadosDasParcelas(double totalSaldoDevedor, double jurosMensal, double totalMeses)
    {
        double amortizacao = this.calculaAmortizacao(totalSaldoDevedor, totalMeses);
        double taxa = jurosMensal / 100;
        double totalJuros = 0;
        double totalAmortizacao = 0;

        for(int i = 1; i <= totalMeses; i++)
        {
            double jurosMensais = this.calculaJurosMensal(totalSaldoDevedor, taxa);
            double valorParcela = this.calculaParcelaMensal(amortizacao, jurosMensal);
            totalJuros += jurosMensais;
            totalAmortizacao += amortizacao;

            totalSaldoDevedor = this.calculaSaldoDevedor(totalSaldoDevedor, amortizacao);

            System.out.printf("Parcela %d: | Juros: R$ %.2f | Prestação: R$ %.2f | Saldo Devedor: R$ %.2f \n",
                    i, jurosMensais, valorParcela, totalSaldoDevedor);

        }
        double totalPrestacoes = totalJuros + totalAmortizacao;

        System.out.printf("TOTAL: Prestação: R$ %.2f, Juros: R$ %.2f, Amortização: R$ %.2f",
                totalPrestacoes, totalJuros, totalAmortizacao );
    }
}
