package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.exceptions.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.Title();
        if (tituloOmdb.Year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano para integer pois o comprimento de ano " +
                    "é maior que 4 digitos");
        }
        this.anoDeLancamento = Integer.parseInt(tituloOmdb.Year());
        this.duracaoEmMinutos = Integer.parseInt(tituloOmdb.Runtime().substring(0, 2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println(String.format("""
                    Nome do filme: %s
                    Ano de lançamento: %d
                    """, nome, anoDeLancamento));
    }

    public void avalia(double nota) {
        somaAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double getMedia() {
        return somaAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome = " + nome + " | anoDeLancamento = " + anoDeLancamento + " | duracao = " + duracaoEmMinutos + ")";
    }
}
