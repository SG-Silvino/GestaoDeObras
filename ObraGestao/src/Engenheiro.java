
import java.io.*;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL-PC
 */
public class Engenheiro {
    Scanner tec = new Scanner(System.in);
    int idEngenheiro;
    String nomeEng, enderecoEng, contatoEng, emailEng, salarioEng;
    
    public void CadastarEngenheiro() throws IOException{
        File arquivo[];
        File diretorio = new File("C:/GestaoDeObras/Engenheiros");
        arquivo = diretorio.listFiles();
        idEngenheiro = arquivo.length + 1;
        
        System.out.print("Nome do Engenheiro: ");
        nomeEng = tec.nextLine();
        System.out.print("Endereco do Engenheiro: ");
        enderecoEng = tec.nextLine();
        System.out.print("Contato do Engenheiro: ");
        contatoEng = tec.nextLine();
        System.out.print("Email do Engenheiro: ");
        emailEng = tec.nextLine();
        System.out.print("Salario do Engenheiro: ");
        salarioEng = tec.nextLine();
        
        
        String caminho = "C:/GestaoDeObras/Engenheiros/" + idEngenheiro + " " + nomeEng + ".txt"; //Caminho da pasta onde seus dados serão armazenados
        
            try (FileWriter arq = new FileWriter(caminho)) {
                PrintWriter escrever = new PrintWriter(arq);
            
                escrever.printf("id: %s \nNome: %s \nEndereco: %s \nContato: %s \nEmail: %s \nSalario: %s mil", idEngenheiro, nomeEng, enderecoEng, contatoEng, emailEng, salarioEng);
                System.out.println("\n");
            }
    }
    
    public void ConsultarEngenheiro(){
            System.out.println("\tLista de engenheiros");
            File arquivos[];
            File diretorio = new File("C:/GestaoDeObras/Engenheiros");
            arquivos = diretorio.listFiles();

            for(int i = 0; i < arquivos.length; i++){
                System.out.println("" + arquivos[i] + "\n");
            }
    }
    
    public void ExcluirEngenheiro() throws IOException{
            ConsultarEngenheiro();
            System.out.println("\n\tRemover Engenheiro");
            
            System.out.print("Escreva nome do arquivo do engenheiro a ser removida: ");
            String nomeEngEx = tec.nextLine();
            
            System.out.print("Tem certeza que deseja excluir: " + nomeEngEx + "? [S/N]: ");
            String resposta = tec.nextLine();
            
                if(resposta == "S" || resposta == "s"){
                    System.out.println("O arquivo vai ser eliminado e vai ser guardado na pasta backups");
                    File f = new File("C:/GestaoDeObras/Engenheiros/" + nomeEngEx);

                    if(!f.exists()){
                        System.out.println("Arquivo inexistente");
                        System.exit(0);
                    }

                    FileWriter arq = new FileWriter("C:/GestaoDeObras/Backups/Engenheiros/" + nomeEngEx);
                    PrintWriter escrever = new PrintWriter(arq);

                    escrever.printf("Obra %s removido\n", nomeEngEx);

                    FileReader ler = new FileReader("C:/GestaoDeObras/Engenheiros/" + nomeEngEx);
                    BufferedReader reader = new BufferedReader(ler);  
                    String linha;
                    while( (linha = reader.readLine()) != null){
                        escrever.printf(linha + "\n");
                    }
                    arq.close();
                    ler.close();
                    f.delete(); //elimina o ficheiro
                }
                else{
                    System.out.println("A Exclusao de " + nomeEngEx + " foi cancelada");
                }
   
        }
}
