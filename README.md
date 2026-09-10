# 📝 To-Do List em Java (CLI)

> Aplicação de gerenciamento de tarefas via linha de comando (CLI) desenvolvida em Java para praticar e consolidar conceitos fundamentais de desenvolvimento de software e sintaxe moderna do Java.

---

## Funcionalidades

- **Adicionar Tarefa:** Cadastro de novas tarefas com estado inicial pendente (`[ ]`).
- **Listar Tarefas:** Exibição de todas as tarefas cadastradas e seus respectivos status.
- **Concluir Tarefa:** Atualização do status de uma tarefa para concluída (`[X]`).
- **Remover Tarefa:** Exclusão de tarefas existentes na lista a partir do seu número identificador.
- **Tratamento de Erros:** Captura e tratamento de exceções de entrada para evitar travamentos do programa quando o usuário digita opções/índices inválidos.

---

## 🛠️ Conceitos e Tecnologias Aplicadas

* **Orientação a Objetos (POO):** Abstração do domínio de tarefas e modelo de dados encapsulado.
* **Classes Aninhadas (`static class`):** Encapsulamento da classe `Tarefa` dentro da classe principal `ToDoList`, mantendo um agrupamento lógico e organização de código.
* **Estruturas de Dados Dinâmicas:** Uso de `ArrayList` para armazenamento e manipulação das tarefas em memória.
* **Entrada e Saída (I/O):** Leitura contínua do teclado via `Scanner` utilizando boas práticas de controle de buffer (`nextLine()`).
* **Sintaxe Moderna do Java (14+):** Uso do `switch` com sintaxe de seta (`->`).
* **Tratamento de Exceções:** Validação de entradas numéricas utilizando blocos `try/catch` para `NumberFormatException`.

---

## 💻 Como Executar o Projeto

### Pré-requisitos

* **Java Development Kit (JDK 14 ou superior)** instalado.

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/KAUAN-KAWASAKI/ToDoList.git
   ```

2. **Acessar a pasta do projeto:**
   ```bash
   cd ToDoList
   ```

3. **Compilar o arquivo Java:**
   ```bash
   javac ToDoList.java
   ```

4. **Executar o programa:**
   ```bash
   java ToDoList
   ```

---

## 📂 Estrutura do Repositório

```text
ToDoList/
├── ToDoList.java   # Código-fonte principal da aplicação
└── README.md       # Documentação do projeto
```

---

## Autor

Desenvolvido por **Kauan Kawasaki**.

* GitHub: [@KAUAN-KAWASAKI](https://github.com/KAUAN-KAWASAKI)
