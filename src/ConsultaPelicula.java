import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;

public class ConsultaPelicula {

    public Pelicula buscaPelicula(int numeroPelicula){
        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+numeroPelicula+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), Pelicula.class);
    }
}
