package br.univille;
import br.univille.entity.Cidade;
import br.univille.entity.Cliente;
import br.univille.entity.Pokemon;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");

        var cliente = new Cliente();
        cliente.setNome("Mario");
        cliente.setIdade(20);
        cliente.setPeso(70);


        Cidade cidade = new Cidade("jlle");
        cliente.setCidade(cidade);


        var kadabra = new Pokemon ("kadabra");
        var raichu = new Pokemon("raichu");

        cliente.getListaPokemon().add(kadabra);
        cliente.getListaPokemon().add(raichu);

        System.out.println();



    }

    

}


