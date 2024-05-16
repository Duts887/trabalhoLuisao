import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
		// String path = "/tmp/file.txt";
		// ManipuladorArquivo.Escritor(path);
		// ManipuladorArquivo.Leitor(path);

		// Carregador crg = new Carregador();
		// crg.Executar();

		ManipuladorArquivo manipulador = new ManipuladorArquivo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo: ");
		String path = sc.nextLine();
		manipulador.Leitor(path);
		sc.close();
		
		manipulador.Escritor("file.txt");
    }
}
