/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package at5;

import at5.classes.*;

/**
 *
 * @author kaique
 */
public class TestePagamento {

    public static void main(String[] args) {
    	Pagamento pagamentoCartao = new PagamentoCartao(100.0);
    	Pagamento pagamentoBoleto = new PagamentoBoleto(250.0);
    	
    	pagamentoBoleto.exibirDetalhes();
    	pagamentoCartao.exibirDetalhes();
    	
    }

}
