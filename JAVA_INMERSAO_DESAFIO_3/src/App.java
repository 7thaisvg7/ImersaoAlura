import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        API api = API.NASA;

        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados 
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

            Conteudo conteudo = conteudos.get(0);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String title = "Shaped Star";
            String nomeArquivo = "saida/" + title + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(title);
            System.out.println(conteudo.urlImagem());
            System.out.println();
    }
}
