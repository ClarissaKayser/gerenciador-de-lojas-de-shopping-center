import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override 
    public String toString() {
        return "Nome do Shopping: " + nome + ". Endereço: " + endereco + ". Lojas: " + Arrays.toString(lojas);
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nome) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nome)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
        int contador = 0;

        for (Loja loja : lojas) {
            if (loja != null) {
                switch (tipo.toLowerCase()) {
                    case "cosmético":
                        if (loja instanceof Cosmetico) contador++;
                        break;
                    case "vestuário":
                        if (loja instanceof Vestuario) contador++;
                        break;
                    case "bijuteria":
                        if (loja instanceof Bijuteria) contador++;
                        break;
                    case "alimentação":
                        if (loja instanceof Alimentacao) contador++;
                        break;
                    case "informática":
                        if (loja instanceof Informatica) contador++;
                        break;
                    default:
                        return -1;
                }
            }
        }
        return contador;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCaro = null;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica inf) {
                if (maisCaro == null || inf.getSeguroEletronicos() > maisCaro.getSeguroEletronicos()) {
                    maisCaro = inf;
                }
            }
        }
        return maisCaro;
    }

}

