
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class Obra {
    Engenheiro eng = new Engenheiro();
    
    
    String nomeObra, enderecoObra, previsaoEntrega, nmEng;
    
    int valorObra, idObra = 0, valorCustoTotalProd = 0, totaolUnidadeProd = 0, CustoPorUnidade, precoTotalUniParaVenda, precoCadaUniParaVenda;
    float Lucro;
    Scanner tex = new Scanner(System.in);
    
    public void CadastrarObra() throws IOException{
        Date data = new Date();
        GregorianCalendar dataCal = new GregorianCalendar();
        dataCal.setTime(data);
        int mes = dataCal.get(Calendar.MONTH);
        
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        
        
            
            File arquivos[];
            File diretorio = new File("C:/GestaoDeObras/Obras");
            arquivos = diretorio.listFiles();

            idObra = arquivos.length + 1; //qtd de arquivos que estao no diretorio assim considera que o proximo idObra sera a qtd de arquivos

            System.out.println("\tCadastro de Obra\n");
            System.out.print("Nome da obra: ");
            nomeObra = tex.nextLine();
            System.out.print("Endereço: ");
            enderecoObra = tex.nextLine();
            
            eng.ConsultarEngenheiro();
            System.out.println("Escolha o engenheiro [sem .txt]: ");
            nmEng = tex.nextLine();
            File f = new File("C:/GestaoDeObras/Engenheiros/" + nmEng + ".txt");
            
            
            for(int i = mes; i < meses.length; i++){ //registro apartir do mes atual
                System.out.print("Quantas unidades de " + nomeObra + " a ser produzido no mes " + meses[i] + ": ");
                totaolUnidadeProd += tex.nextInt();
            }
            
            System.out.print("Custo para produzir uma unidade: ");
            CustoPorUnidade = tex.nextInt();
            
            valorObra = CustoPorUnidade * totaolUnidadeProd;
            precoTotalUniParaVenda = (int) (valorObra * 1.2);
            precoCadaUniParaVenda = precoTotalUniParaVenda / totaolUnidadeProd;
            Lucro = (float) (valorObra * 0.2);

            String caminho = "C:/GestaoDeObras/Obras/" + idObra + " " + nomeObra + " " + ".txt"; //Caminho da pasta onde seus dados serão armazenados
        
            try (FileWriter arq = new FileWriter(caminho)) {
                PrintWriter escrever = new PrintWriter(arq);
            
                escrever.printf("id: %s \nNome: %s \nEndereco: %s \nValor: %s mil \npreco/unidade: %s\n Lucro: %s\n \nID Engenheiro: %s", idObra,
                        nomeObra, enderecoObra, valorObra, precoCadaUniParaVenda, Lucro, nmEng);
                escrever.close();

                System.out.println("\n");
            }
            
        }
        
        public void ConsultarObras(){
            System.out.println("\tLista de Obras");
            File arquivos[];
            File diretorio = new File("C:/GestaoDeObras/Obras");
            arquivos = diretorio.listFiles();

            for(int i = 0; i < arquivos.length; i++){
                System.out.println("" + arquivos[i] + "\n");
            }
        }
        
        public void ExcluirObra() throws IOException{
            ConsultarObras();
            System.out.println("\n\tRemover Obra");
            
            System.out.print("Escreva nome do arquivo da obra a ser removida: ");
            String nomeObraEx = tex.nextLine();
            
            System.out.print("Tem certeza que deseja excluir: " + nomeObraEx + "? [S/N]: ");
            String resposta = tex.nextLine();
            
                if(resposta == "S" || resposta == "s"){
                    System.out.println("O arquivo vai ser eliminado e vai ser guardado na pasta backups");
                    File f = new File("C:/GestaoDeObras/Obras/" + nomeObraEx);

                    if(!f.exists()){
                        System.out.println("Arquivo inexistente");
                        System.exit(0);
                    }

                    FileWriter arq = new FileWriter("C:/GestaoDeObras/Backups/Obras/" + nomeObraEx);
                    PrintWriter escrever = new PrintWriter(arq);

                    escrever.printf("Obra %s removido\n", nomeObraEx);

                    FileReader ler = new FileReader("C:/GestaoDeObras/Obras/" + nomeObraEx);
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
                    System.out.println("A Exclusao de " + nomeObraEx + " foi cancelada");
                }
   
        }
        
        public void AlterarObra() throws IOException{
            ConsultarObras();
            
            String caminho = "C:/GestaoDeObras/Obras/" + idObra + " " + nomeObra + " " + ".txt";
            
            Date data = new Date();
        GregorianCalendar dataCal = new GregorianCalendar();
        dataCal.setTime(data);
        int mes = dataCal.get(Calendar.MONTH);
        
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        
        
            
            File arquivos[];
            File diretorio = new File("C:/GestaoDeObras/Obras");
            arquivos = diretorio.listFiles();

            idObra = arquivos.length + 1; //qtd de arquivos que estao no diretorio assim considera que o proximo idObra sera a qtd de arquivos

            System.out.println("\tCadastro de Obra\n");
            System.out.print("Nome da obra: ");
            nomeObra = tex.nextLine();
            System.out.print("Endereço: ");
            enderecoObra = tex.nextLine();
            
            eng.ConsultarEngenheiro();
            System.out.println("Escolha o engenheiro [sem .txt]: ");
            nmEng = tex.nextLine();
            File f = new File("C:/GestaoDeObras/Engenheiros/" + nmEng + ".txt");
            
            
            for(int i = mes; i < meses.length; i++){ //registro apartir do mes atual
                System.out.print("Quantas unidades de " + nomeObra + " a ser produzido no mes " + meses[i] + ": ");
                totaolUnidadeProd += tex.nextInt();
            }
            
            System.out.print("Custo para produzir uma unidade: ");
            CustoPorUnidade = tex.nextInt();
            
            valorObra = CustoPorUnidade * totaolUnidadeProd;
            precoTotalUniParaVenda = (int) (valorObra * 1.2);
            precoCadaUniParaVenda = precoTotalUniParaVenda / totaolUnidadeProd;
            Lucro = (float) (valorObra * 0.2);

            String caminho2 = "C:/GestaoDeObras/Obras/" + idObra + " " + nomeObra + " " + ".txt"; //Caminho da pasta onde seus dados serão armazenados
        
            try (FileWriter arq = new FileWriter(caminho)) {
                PrintWriter escrever = new PrintWriter(arq);
            
                escrever.printf("id: %s \nNome: %s \nEndereco: %s \nValor: %s mil \npreco/unidade: %s\n Lucro: %s\n \nID Engenheiro: %s", idObra,
                        nomeObra, enderecoObra, valorObra, precoCadaUniParaVenda, Lucro, nmEng);
                escrever.close();

                System.out.println("\n");
            }

            
            new File(caminho).renameTo(new File(caminho2));//Renomendo o ficheiro
        }
}
