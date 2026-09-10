import java.util.ArrayList;
import java.util.Scanner;

/*
Aplicativo de lista de tarefas (To-Do List) via terminal.
-> Conceitos praticados aqui:
1. Classe aninhada (Tarefa)
2. ArrayList (lista dinâmica)
3. Scanner (leitura do teclado)
4. Estruturas de repetição e decisão (do-while, switch)
5. Tratamento de erros com try/catch
*/

public class ToDoList {
    // Classe interna (aninhada) que representa uma única tarefa.
    // Definimos ela "dentro" da TodoList porque só faz sentido usá-la aqui.
    static class Tarefa {
        String descricao;   // texto da tarefa, ex: "Estudar Java"
        boolean concluida;  // true = feita, false = pendente

        // Construtor: roda automaticamente quando criamos uma nova Tarefa.
        // Toda tarefa nova começa como "não concluída".
        Tarefa(String descricao) {
            this.descricao = descricao;
            this.concluida = false;
        }

        // Sobrescrevemos o toString() para controlar como a tarefa
        // aparece quando usamos System.out.println(tarefa).
        @Override
        public String toString() {
            String status = concluida ? "[X]" : "[ ]"; // operador ternário: condição ? seVerdadeiro : seFalso
            return status + " " + descricao;
        }
    }

    // Lista que guarda todas as tarefas em memória (RAM).
    // Importante: ao fechar o programa, essa lista se perde (não tem persistência ainda).
    static ArrayList<Tarefa> tarefas = new ArrayList<>();

    // Scanner é o "objeto leitor" do teclado. Criamos só um para reaproveitar.
    static Scanner scanner = new Scanner(System.in);

    // Ponto de entrada do programa (estilo tradicional, Java clássico).
    public static void main(String[] args) {
        int opcao;

        // do-while: executa o bloco PELO MENOS uma vez, e repete
        // enquanto a condição (opcao != 0) for verdadeira.
        do {
            exibirMenu();
            opcao = lerOpcao();

            // switch moderno (arrow syntax, Java 14+): mais limpo que o switch antigo com "case: break;"
            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> listarTarefas();
                case 3 -> concluirTarefa();
                case 4 -> removerTarefa();
                case 0 -> System.out.println("Saindo... até mais!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close(); // boa prática: fechar o recurso ao terminar
    }

    // Mostra as opções disponíveis para o usuário.
    static void exibirMenu() {
        System.out.println("\n===== TO-DO LIST =====");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Marcar tarefa como concluída");
        System.out.println("4 - Remover tarefa");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção digitada e converte de texto (String) para número (int).
    // Se o usuário digitar algo que não é número, capturamos o erro
    // e devolvemos -1, que cai no "default" do switch (opção inválida).
    static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Pede a descrição da nova tarefa e adiciona na lista.
    static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(descricao)); // cria uma Tarefa nova e adiciona na lista
        System.out.println("Tarefa adicionada com sucesso!");
    }

    // Percorre a lista e imprime cada tarefa numerada.
    static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return; // sai do método aqui, não precisa continuar
        }

        System.out.println("\n--- Suas tarefas ---");
        for (int i = 0; i < tarefas.size(); i++) {
            // i + 1 porque para o usuário é mais natural contar a partir de 1, não de 0
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
    }

    // Marca uma tarefa existente como concluída.
    static void concluirTarefa() {
        listarTarefas();
        if (tarefas.isEmpty()) return;

        System.out.print("Digite o número da tarefa concluída: ");
        int index = lerIndice();

        // Verificamos se o índice digitado realmente existe na lista,
        // para evitar erro de "IndexOutOfBounds".
        if (index >= 0 && index < tarefas.size()) {
            tarefas.get(index).concluida = true;
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    // Remove uma tarefa da lista.
    static void removerTarefa() {
        listarTarefas();
        if (tarefas.isEmpty()) return;

        System.out.print("Digite o número da tarefa a remover: ");
        int index = lerIndice();

        if (index >= 0 && index < tarefas.size()) {
            tarefas.remove(index);
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    // Método auxiliar: converte o número digitado pelo usuário (1, 2, 3...)
    // para o índice real da lista (0, 1, 2...), já tratando erro de digitação.
    static int lerIndice() {
        try {
            return Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
