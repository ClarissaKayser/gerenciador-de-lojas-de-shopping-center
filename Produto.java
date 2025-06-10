public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Nome do Produto: " + nome + ". Preço: " + preco + ". Validade: " + (dataValidade != null ? dataValidade.toString() : "Sem data de validade");
        }

     public boolean estaVencido(Data dataProduto){
        if (this.dataValidade.getAno() < dataProduto.getAno()) { //verifica se ano é menor
            return true;
        } else if (this.dataValidade.getAno() == dataProduto.getAno()) { //verifica se ano é igual
            if (this.dataValidade.getMes() < dataProduto.getMes()) { //se ano igual, verifica se mes é menor
                return true;
            } else if (this.dataValidade.getMes() == dataProduto.getMes()) {//se nao for menor, verifica se mes é igual
                return this.dataValidade.getDia() < dataProduto.getDia();//se mes igual, verifica se dia é menor
            }    
        }
        return false;
     }
} 