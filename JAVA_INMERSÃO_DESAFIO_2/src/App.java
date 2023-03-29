import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class App  {

    public static void gerar() throws Exception {
        // leer la imagen y datos
        BufferedImage imagen_og = ImageIO.read(new File("imagens/Original.jpg"));
        int width = imagen_og.getWidth();
        int height = imagen_og.getHeight();
        
        //modificar la imagen
        int add_height = (int) (0.25*height);
        int new_height = (int) (height + add_height);
        BufferedImage imagen_nova = new BufferedImage(width, new_height, BufferedImage.TRANSLUCENT);

        //obtener la nueva imagen
        Graphics2D graphics = (Graphics2D) imagen_nova.getGraphics();
        graphics.drawImage(imagen_og, 0, 0, null);

        // configurar a fonte
        int size_fonte = (int)(add_height*0.6); 
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, size_fonte);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", (int)(width*0.25), (int)(new_height*0.95));        

        //obtener la nueva imagen como archivo
        ImageIO.write(imagen_nova, "png", new File("imagens/resultado.png"));
    }
    public static void main(String[] args) throws Exception {
        App.gerar();
    }
}
