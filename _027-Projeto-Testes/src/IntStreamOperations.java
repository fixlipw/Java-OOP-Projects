
import java.util.stream.IntStream;

@SuppressWarnings("ALL")
public class IntStreamOperations {
    public static void main(String[] args) {
        int[] valores = {3,5,9,8,7,1,2,10,4,6};
        // Exibindo valores originais
        System.out.println("Exibindo valores originais: ");
        IntStream.of(valores)
                .forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();

        // Usando count, min, max, sum, averange
        System.out.printf("%nCout: %d%n", IntStream.of(valores).count());
        System.out.printf("Min: %d%n",
                IntStream.of(valores).min().getAsInt());
        System.out.printf("Max: %d%n",
                IntStream.of(valores).max().getAsInt());
        System.out.printf("Sum: %d%n",
                IntStream.of(valores).sum());
        System.out.printf("Averange: %.2f%n",
                IntStream.of(valores).average().getAsDouble());

        // Soma valores com o método reduce
        System.out.printf("Soma com o método reduce: %d%n",
                IntStream.of(valores)
                        .reduce(0, (x, y) -> x+y));

        // Soma das raizes quadradas dos valores com reduce
        System.out.printf("Soma dos quadrados dos números com reduce: %d%n",
                IntStream.of(valores)
                        .reduce(1, (x, y) -> x + y*y));

        // Produto dos valores com método reduce
        System.out.printf("Produto com método reduce: %d%n",
                IntStream.of(valores)
                        .reduce(1, (x, y) -> x*y));

        // Valores pares em ordem
        System.out.print("Valores pares em ordem: ");
        IntStream.of(valores)
                .filter(valor -> valor % 2 == 0)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();

        // Valores ímpares multiplicados por 10 em ordem
        System.out.print("Valores ímpares multiplicados por 10 em ordem: ");
        IntStream.of(valores)
                .filter(valor -> valor % 2 != 0)
                .map(valor -> valor * 10)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();
    }
}
