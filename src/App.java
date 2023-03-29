import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       

        // parsear(extrair) só os dados que interessam (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            String titulo = filme.get( "title");
            System.out.println("\u001b[1m\u001b[3m\u001b[48;2;42;228;122m"+ titulo +"\u001b[m");
            System.out.println(filme.get("image"));
            String rating = filme.get("imDbRating");
            double avaliacao = Math.round(Double.valueOf(rating));
            for(int i=0; i<avaliacao; i++){
                System.out.print("\u2B50");
            }
            System.out.println();
            System.out.println();
        }

    }
}
