package br.com.infnet.infnetrefactoringstartingpoint.locadora;

public class Locacao {
    private Filme filme;
    private int diasAlugados;

    public Locacao(Filme filme, int diasAlugados) {
        this.filme = filme;
        this.diasAlugados = diasAlugados;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getDiasAlugados() {
        return diasAlugados;
    }
    public int getPontosLocadorFrequente() {
        if(getFilme().getCodigoPreco() == Filme.LANCAMENTO && getDiasAlugados() > 1 ){
            return 2;
        }else return 1;

    }

    public void setDiasAlugados(int diasAlugados) {
        this.diasAlugados = diasAlugados;
    }
    public Double getPreco(){
        double quantidadeFinal = 0;
        switch (getFilme().getCodigoPreco()){
            case Filme.NORMAL :
                quantidadeFinal += 2;
                if(getDiasAlugados() > 2 ){
                    quantidadeFinal += (getDiasAlugados() - 2) * 1.5;
                }
                break;
            case Filme.LANCAMENTO:
                quantidadeFinal += getDiasAlugados() * 3;
                break;
            case Filme.INFANTIL:
                quantidadeFinal += 1.5;
                if(getDiasAlugados() > 3) {
                    quantidadeFinal += (getDiasAlugados() - 3) * 1.5;
                }
                break;
        }
        return quantidadeFinal;
    }
}
