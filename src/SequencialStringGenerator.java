import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequencialStringGenerator {
    private List<Double> valores;
    private double somaTotal;

    public SequencialStringGenerator() {
        this.valores = new ArrayList<>();
        this.somaTotal = 0.0;
    }

    public void adicionarValor(double valor) {
        valores.add(valor);
    }

    public String gerarSequencialString() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Remessa gerada: ");

        for (int i = 0; i < valores.size(); i++) {
            int sequencial = i + 1;
            double valor = valores.get(i);

            somaTotal += valor;

            resultado.append(sequencial)
                    .append(" cujo valor é R$ ")
                    .append(String.format("%.2f", valor));

            if (i < valores.size() - 1) {
                resultado.append(", ");
            } else {
                resultado.append(". Total = ")
                        .append(String.format("R$ %.2f", somaTotal))
                        .append(".");
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SequencialStringGenerator gerador = new SequencialStringGenerator();

        System.out.println("Digite os valores (insira 'fim' para encerrar a entrada):");

        while (true) {
            System.out.print("Valor: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("fim")) {
                break;
            }

            try {
                double valor = Double.parseDouble(input);
                gerador.adicionarValor(valor);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }

        String resultado = gerador.gerarSequencialString();
        System.out.println("\nResultados:\n" + resultado);

        scanner.close();
    }
}
