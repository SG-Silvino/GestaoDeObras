
import java.io.IOException;
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
public class GestaoDeObras {
    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(System.in);
        Obra o = new Obra();
        Engenheiro eng = new Engenheiro();
        
        System.out.print("1)Cadastrar Obra\n2)Consultar Obra\n3)Excluir Obra\n"
                + "4)Cadastrar Engenheiro\n5)Consultar Engenheiro\n6)Excluir Engenheiro\n"
                + "Excolha: ");
        int escolha = r.nextInt();
        
        switch(escolha){
            case 1:
                o.CadastrarObra();
                break;
            case 2:
                o.ConsultarObras();
                break;
            case 3:
                o.ExcluirObra();
                break;
            case 4:
                eng.CadastarEngenheiro();
                break;
            case 5:
                eng.ConsultarEngenheiro();
                break;
            case 6:
                eng.ExcluirEngenheiro();
                break;
            default:
                System.out.println("Opçao invalida");
                System.exit(0);
                break;
        }
        
    }
}
