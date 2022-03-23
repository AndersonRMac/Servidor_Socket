package servidor_socket1;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


class Servidor_socket{
        public static void main(String[] args) {
                System.out.println("Servidor Iniciado...");
        
                //Cria um socket na porta 5225
                ServerSocket servidor;
                try {
                    servidor = new ServerSocket(5225);
                    System.out.println("Porta 5225 aberta!");
        
                System.out.println("Aguardando conexão do cliente...");
                Socket cliente = servidor.accept();
        
                System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());

                Scanner entrada = new Scanner(cliente.getInputStream());
                int soma = 0;
                 
                while (entrada.hasNextInt()) {
                        
                    int num = entrada.nextInt();
                    System.out.println(num);

                    if (num > 0) {
                        soma = soma + num;
                    }
                    else{
                        break;
                    }
                        
                    }
                
                entrada.close();servidor.close();cliente.close();
                
                System.out.println("A soma dos numeros digitados é: " + soma);   

                } catch (IOException e) {
                    System.out.println("Erro ao iniciar servidor");
                }
                
        
        
        }   
}