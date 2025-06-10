public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public boolean validaData(int dia, int mes, int ano) {
        int[] verificaMes = {31, verificaAnoBissexto(ano) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes < 1 || mes > 12) {
            return false;
        } else if (dia < 1 || dia > verificaMes[mes - 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaAnoBissexto() {
        return verificaAnoBissexto(this.ano);
    }
    
    public  boolean verificaAnoBissexto(int ano) {
        if (ano % 400 == 0) {
            return true;
        } else if (ano % 100 == 0) {
            return false;
        } else {
            return ano % 4 == 0;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }


}