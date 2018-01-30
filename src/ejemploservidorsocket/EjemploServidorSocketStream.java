/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploservidorsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

/*
ServerSocket es conexion TCP, DatagramSocket es conexion UDP
*/

public class EjemploServidorSocketStream {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = serverSocket.accept();

            System.out.println("Conexi�n recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();
            
            
            //Esto es el numero de bytes que leemos? parece que si
            byte[] mensaje = new byte[30];
            //el metodo is.read() devuelve el numero de bytes leidos del stream
            int bytesLeidos=is.read(mensaje);
            
            System.out.println("Mensaje recibido: " + new String(mensaje).trim() +","+ bytesLeidos+"bytes");
            
            bytesLeidos=is.read(mensaje);
            
            System.out.println("Mensaje recibido: " + new String(mensaje).trim() +","+ bytesLeidos+"bytes");
            
            

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
