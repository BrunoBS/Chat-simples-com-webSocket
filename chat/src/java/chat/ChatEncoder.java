/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail: bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 * 
 */

public class ChatEncoder implements Encoder.Text<Mensagem>{

    @Override
    public String encode(Mensagem figura) throws EncodeException {
        return figura.getJson().toString();
    }

    @Override
    public void init(EndpointConfig config) {       
    }

    @Override
    public void destroy() {
    }    
    
}
