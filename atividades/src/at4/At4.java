/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package at4;

import at4.classes.*;

/**
 *
 * @author kaique
 */
public class At4 {

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

        System.out.println("Ve�culo:");
        veiculo.exibirDetalhes();

        System.out.println("\nCarro:");
        carro.exibirDetalhes();

        System.out.println("\nMoto:");
        moto.exibirDetalhes();
    }

}
