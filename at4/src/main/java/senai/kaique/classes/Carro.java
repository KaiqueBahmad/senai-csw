package senai.kaique.classes;

public class Carro extends Veiculo {
    private int numeroPortas;

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Numero de portas: "+numeroPortas);
    }
    
    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
}
