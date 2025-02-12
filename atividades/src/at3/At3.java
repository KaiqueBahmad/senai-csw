/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package at3;

import at3.classes.Produto;

/**
 *
 * @author kaique
 */
public class At3 {

	public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Smartphone");
        produto.setPreco(1499.99);
        
        System.out.println("Estado inicial do produto:");
        produto.exibirInformacoes();
        
        System.out.println("\nAdicionando 10 unidades:");
        produto.adicionarEstoque(10);
        produto.exibirInformacoes();
        
        System.out.println("\nRemovendo 3 unidades:");
        produto.removerEstoque(3);
        produto.exibirInformacoes();
        
        System.out.println("\nTentando remover 8 unidades:");
        produto.removerEstoque(8);
        
        System.out.println("\nAdicionando mais 5 unidades:");
        produto.adicionarEstoque(5);
        produto.exibirInformacoes();
    }
}
