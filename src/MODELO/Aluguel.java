package MODELO;

public class Aluguel {

 int cod;
 int codlocal;
 int codequipamento;
 int codprofessor;
 String datareservada;
 String datadevolvida;
 String aula;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(int codlocal) {
        this.codlocal = codlocal;
    }

    public int getCodequipamento() {
        return codequipamento;
    }

    public void setCodequipamento(int codequipamento) {
        this.codequipamento = codequipamento;
    }

    public int getCodprofessor() {
        return codprofessor;
    }

    public void setCodprofessor(int codprofessor) {
        this.codprofessor = codprofessor;
    }

    public String getDatareservada() {
        return datareservada;
    }

    public void setDatareservada(String datareservada) {
        this.datareservada = datareservada;
    }

    public String getDatadevolvida() {
        return datadevolvida;
    }

    public void setDatadevolvida(String datadevolvida) {
        this.datadevolvida = datadevolvida;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
 
 
    
}