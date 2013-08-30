/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail: bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 * 
 */
@ServerEndpoint(value = "/chatendpoint", encoders = {ChatEncoder.class}, decoders = {ChatDecoder.class})
public class Chat {

    private static Set<Session> clientes = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session cliente) {
        clientes.add(cliente);
    }

    @OnClose
    public void onClose(Session cliente) {
        clientes.remove(cliente);
    }

    @OnMessage
    public void broadcastFigura(Mensagem mensagem, Session session) throws IOException, EncodeException {
        System.out.println("Mensagem: " + mensagem);
        for (Session cliente : clientes) {
            //     if (!cliente.equals(session)) {
            cliente.getBasicRemote().sendObject(mensagem);
            //      }
        }

    }
}
