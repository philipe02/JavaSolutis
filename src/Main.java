import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);

        //1 . imprima todos os itens da lista no console
        System.out.println("1 . imprima todos os itens da lista no console");

        numbers.forEach(num -> System.out.print(num + " "));

        //2 . imprima os números distintos em ordem crescente
        System.out.println("\n2 . imprima os números distintos em ordem crescente");

        numbers.stream()
                .distinct()
                .sorted(Integer::compareTo)
                .forEach(num -> System.out.print(num + " "));

        //3 . imprima os números impares  e distintos em ordem decrescente
        System.out.println("\n3 . imprima os números impares  e distintos em ordem decrescente");

        numbers.stream()
                .distinct()
                .filter(num -> num % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .forEach(num -> System.out.print(num + " "));

        //4. imprima a soma dos números ignorando os 3 primeiros
        System.out.println("\n4. imprima a soma dos números ignorando os 3 primeiros");

        System.out.print(
                numbers.stream()
                        .skip(3)
                        .reduce(Integer::sum)
                        .get()
        );

        //5. imprima cada número da lista multiplicado por 2
        System.out.println("\n5. imprima cada número da lista multiplicado por 2");

        numbers.stream()
                .map(num -> num * 2)
                .forEach(num -> System.out.print(num + " "));

        //6. imprima de forma agrupada os números pares e impares distintos
        System.out.println("\n6. imprima de forma agrupada os números pares e impares distintos");

        System.out.print("Pares: ");

        numbers.stream()
                .distinct()
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.print(num + " "));

        System.out.print("\nÍmpares: ");

        numbers.stream()
                .distinct()
                .filter(num -> num % 2 != 0)
                .forEach(num -> System.out.print(num + " "));

        //7. imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException
        System.out.println("\n7. imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException");

        System.out.print(
                numbers.stream()
                .max(Integer::compareTo)
                        .orElseThrow(NoSuchElementException::new)
        );

        //8. imprima apenas os 3 primeiros números da lista
        System.out.println("\n8. imprima apenas os 3 primeiros números da lista");

        numbers.stream()
                .limit(3)
                .forEach(num -> System.out.print(num + " "));

        //9. imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN
        System.out.println("\n9. imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN");

        System.out.printf(
                "%.2f",
                numbers.stream()
                .mapToDouble(num -> num)
                .average()
                .orElse(Double.NaN)
        );

        //10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo
        System.out.println("\n10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo");

        System.out.println("Quantidade de itens: "+ numbers.size());
        System.out.println("Soma dos elementos: "+ numbers.stream().reduce(Integer::sum).get());
        System.out.println("Média: "+ String.format("%.2f", numbers.stream().mapToDouble(num->num).average().getAsDouble()));
        System.out.print("Valor máximo: "+ numbers.stream().max(Integer::compareTo).get());

        //11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente
        System.out.println("\n11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente");

        numbers.stream()
                .distinct()
                .sorted(Integer::compareTo)
                .forEach(num -> {
                    System.out.println(
                            LocalDate.now()
                                    .plusDays(num)
                                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    );
                });

    }
}
