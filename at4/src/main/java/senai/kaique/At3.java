/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package senai.kaique;

import senai.kaique.classes.Carro;
import senai.kaique.classes.Moto;
import senai.kaique.classes.Veiculo;

/**
 *
 * @author kaique
 */
public class At3 {

    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Ford");
        veiculo.setModelo("Focus");
        veiculo.setAno(2022);

        Carro carro = new Carro();
        carro.setMarca("Toyota");
        carro.setModelo("Corolla");
        carro.setAno(2024);
        carro.setNumeroPortas(4);

        Moto moto = new Moto();
        moto.setMarca("Honda");
        moto.setModelo("CBR");
        moto.setAno(2023);
        moto.setCilindradas(600);

        System.out.println("Veículo:");
        veiculo.exibirDetalhes();

        System.out.println("\nCarro:");
        carro.exibirDetalhes();

        System.out.println("\nMoto:");
        moto.exibirDetalhes();
    }

}
