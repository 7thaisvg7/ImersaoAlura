import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

//https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adreess = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adreess).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        //extraer sólo los datos que me interesan
        var parser = new JsonParser();
        List<Map<String,String>> ListaFilmes = parser.parse(body);
        System.out.println(	"\u2B50");

        for (Map<String,String> filme : ListaFilmes) {
            System.out.println("\n" + ANSI_BLUE +  "Titulo: " + filme.get("title")  + ANSI_RESET);
            System.out.println("Poster: " + filme.get("image"));
            var rating = Float.parseFloat(filme.get("imDbRating"));
            
            String estrelha = "";
            for (int i = 0; i < rating; i++) {
                    estrelha = estrelha + "*";
                }
            System.out.println(ANSI_GREEN + "Rating: " + rating + " " + ANSI_YELLOW + estrelha + ANSI_RESET );
        }
    }
}
