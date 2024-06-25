import java.io.IOException;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el numero dela pelicula de Star Wars que quiere consultar");

    ConsultaPelicula consulta = new ConsultaPelicula();

    try{
        var numeroDePelicula = Integer.valueOf(lectura.nextLine());
        Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
        System.out.println(pelicula);
        GeneradorDeArchivos generador = new GeneradorDeArchivos();
        generador.guardarJson(pelicula);

    }catch (NumberFormatException e){
        System.out.println("Numero no encontrado: "+e.getMessage());
    }
    catch (RuntimeException | IOException e){
        System.out.println(e.getMessage());
        System.out.println("Finalizanddo la aplicacion");
    }

    }
}
