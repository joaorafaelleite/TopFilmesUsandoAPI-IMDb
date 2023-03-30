import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

    public void cria() throws Exception{
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira a URL da imagem:");
        InputStream inputStream = new URL(scan.nextLine()).openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(fonte);
        System.out.println("Digite o texto a ser inserido na figurinha:");
        graphics.drawString(scan.nextLine(), 0, novaAltura-100);        

        String strPath = "C:\\Users\\joaor\\OneDrive\\Área de Trabalho\\DEVELOPER\\WS-VsCodeJAVA\\aluraStickers";
        new File(strPath + "\\saida").mkdir();
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));

        scan.close();
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }

}
