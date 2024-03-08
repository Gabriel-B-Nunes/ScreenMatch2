import br.com.alura.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args){
        Filme filme1 = new Filme();

        filme1.setNome("O Poderoso Chefão");
        filme1.setAnoDeLancamento(1970);
        filme1.setDuracaoEmMinutos(180);
        filme1.setIncluidoNoPlano(true);

        filme1.exibeFichaTécnica();
        filme1.avalia(8);
        filme1.avalia(5);
        filme1.avalia(10);

        System.out.println(filme1.getMedia());
    }
}
