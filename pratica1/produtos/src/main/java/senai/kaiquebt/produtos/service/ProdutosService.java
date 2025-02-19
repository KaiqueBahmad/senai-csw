package senai.kaiquebt.produtos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.springframework.stereotype.Service;

import senai.kaiquebt.produtos.entity.Produto;

@Service
public class ProdutosService {
	
	private Map<Integer, Produto> produtos = new HashMap<>();
	private static int counter = 0;
	
	public List<Produto> listar() {
		return (List<Produto>) produtos.values();
	}
	
	public Produto adicionarProduto(Produto novoProduto) {
		int id = ++counter;
		novoProduto.setId(id);
		produtos.put(id, novoProduto);
		return novoProduto;
	}
	
}
