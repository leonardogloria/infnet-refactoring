package br.com.infnet.infnetrefactoringstartingpoint.locadora;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Locacao> locacoes = new ArrayList<>();

    public String getNome() {
        return nome;
    }
    public void adicionarLocacao(Locacao locacao){
        this.locacoes.add(locacao);
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    public String conta(){
        String resultado = "Registro de locacoes de " + getNome() +  "\n";
        for(Locacao l : locacoes) {
            resultado += "\t" + l.getFilme().getTitulo() + "\t" + String.valueOf(l.getPreco()) + "\n" ;
        }
        //adicionar rodape
        resultado += "O valor devido é: " + String.valueOf(getPrecoTotal()) + "\n";
        resultado += "Você ganhou " + String.valueOf(getTotalPontosLocadorFrequente()) + " pontos de locador frequente";
        return resultado;
    }

    private int getPontosLocadorFrequente(Locacao locacao) {
        if(locacao.getFilme().getCodigoPreco() == Filme.LANCAMENTO && locacao.getDiasAlugados() > 1 ){
            return 2;
        }else return 1;

    }

    private double quantiaDe(Locacao locacao) {
        return locacao.getPreco();
    }
    private Double getPrecoTotal(){
        double quantiaTotal = 0;
        for(Locacao l : locacoes ) {
            quantiaTotal += l.getPreco();
        }
        return quantiaTotal;
    }
    public int getTotalPontosLocadorFrequente(){
        int quantidadeTotal = 0;
        for(Locacao l : locacoes ) {
            quantidadeTotal += l.getPontosLocadorFrequente();
        }
        return quantidadeTotal;

    }

}
