
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
public class Login extends ADM{
    Scanner t = new Scanner(System.in);
    ADM adm = new ADM();
    
    Login(){
        System.out.println("Benvindo ao seu sistema\n");
        
        String user, pass;
        
        System.out.print("Insira Username: ");
        user = t.next();
        
        System.out.print("Insira Senha: ");
        pass = t.next();
        
        System.out.println(user);
        System.out.println(pass);
        System.out.println(adm.usuario);
        System.out.println(adm.senha);
        
            if(adm.usuario == user && adm.senha == pass){
                System.out.println("Logado com sucesso");
            }
            else{
                System.out.println("Erro no login");                  
            }
     
    }
}
