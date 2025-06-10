import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Loja loja = null;
        Produto produto = null;
        int opcao;

        do {
            System.out.println("MENU");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome da loja: ");
                    String nomeLoja = scanner.nextLine();

                    System.out.println("Número de funcionários: ");
                    int qtdFuncionarios = scanner.nextInt();

                    System.out.println("Salário base dos funcionários: ");
                    double salarioBase = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Endereço: ");
                    String rua = scanner.nextLine();

                    System.out.println("Número: ");
                    String numero = scanner.nextLine();

                    System.out.println("Complemento: ");
                    String complemento = scanner.nextLine();
                    
                    System.out.println("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.println("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.println("País: ");
                    String pais = scanner.nextLine();

                    System.out.println("CEP: ");
                    String cep = scanner.nextLine();


                    Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);

                    System.out.println("Dia de fundação: ");
                    int diaFundacao = scanner.nextInt();

                    System.out.println("Mês de fundação: ");
                    int mesFundacao = scanner.nextInt();

                    System.out.println("Ano de fundação: ");
                    int anoFundacao = scanner.nextInt();
                    scanner.nextLine();

                    Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);

                    System.out.print("Tamanho do estoque da loja: ");
                    int tamanhoEstoque = scanner.nextInt();
                    scanner.nextLine();
    
                    loja = new Loja(nomeLoja, qtdFuncionarios, salarioBase, endereco, dataFundacao, tamanhoEstoque);

                    System.out.println("Nova loja criada");
                    break;

                case 2:
                    System.out.println("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.println("Preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.println("Dia de validade: ");
                    int diaValidade = scanner.nextInt();

                    System.out.println("Mês de validade: ");
                    int mesValidade = scanner.nextInt();

                    System.out.println("Ano de validade: ");
                    int anoValidade = scanner.nextInt();
                    scanner.nextLine();

                    Data dataValidade = new Data(diaValidade, mesValidade, anoValidade);

                    produto = new Produto(nomeProduto, preco, dataValidade);

                    System.out.println("Novo produto criado");
                    break;

                case 3:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);

        if (loja != null && produto != null) {
            Data dataValidacao = new Data(20, 10, 2023);
            if (produto.estaVencido(dataValidacao)) {
                System.out.println("O produto está vencido.");
            } else {
                System.out.println("O produto está dentro do prazo de validade.");
            }

            System.out.println("Informações da loja:");
            System.out.println(loja);
        } else {
            System.out.println("Não foi possível criar a loja ou o produto.");
        }

        scanner.close();
    }
}
