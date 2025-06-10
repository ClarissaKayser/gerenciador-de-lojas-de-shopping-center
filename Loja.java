public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[tamanhoEstoque];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[tamanhoEstoque];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

        public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    @Override
    public String toString() {
        return "A loja " + nome + ", foi fundada em " + (dataFundacao != null ? dataFundacao.toString() : 
        "Sem data de fundação") + ". " + (endereco != null ? endereco.toString() : 
        "Sem endereço") + "\nPossui " + quantidadeFuncionarios + " funcionários, com base salarial de R$" 
        + salarioBaseFuncionario + ".\nQuantidade de produtos em estoque nesta loja: " + (estoqueProdutos != null ? estoqueProdutos.length : 0);
    }
 
    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1){
            return -1;
        } else {
            return quantidadeFuncionarios * salarioBaseFuncionario;
        }
    }     

    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10){
            return 'P';
        } else if (quantidadeFuncionarios <=30){
            return 'M';
        } else {
            return 'G';
        }
    }

    public void imprimeProdutos() {
    System.out.println("Produtos:");
    for (int i = 0; i < estoqueProdutos.length; i++) {
        if (estoqueProdutos[i] != null) {
            System.out.println(estoqueProdutos[i]);
        }
    }
}

    public boolean insereProduto(Produto produto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nome) {
        for (int i = 0; i < estoqueProdutos.length; i++) { 
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nome)) {// Verifica se confere produto e nome
                estoqueProdutos[i] = null;// Remove o produto, coloca null
                return true;
            }
        }
        return false;
    }

}