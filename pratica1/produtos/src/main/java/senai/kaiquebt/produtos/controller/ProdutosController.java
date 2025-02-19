package senai.kaiquebt.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senai.kaiquebt.produtos.entity.Produto;
import senai.kaiquebt.produtos.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosService produtosService;
	
	@GetMapping("")
	public List<Produto> getAll() {
		return produtosService.listar();
	}
	
	@PostMapping("")
	public Produto add(@RequestBody Produto produto) {
		return produtosService.adicionarProduto(produto);
	}
	
}
