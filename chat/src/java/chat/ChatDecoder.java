/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Alunos
 */
public class ChatDecoder implements Decoder.Text<Mensagem>{

    @Override
    public void init(EndpointConfig config) {        
    }

    @Override
    public void destroy() {        
    }

    @Override
    public Mensagem decode(String s) throws DecodeException {
        StringReader stringReader=new StringReader(s);
        JsonObject jsonObject= Json.createReader(stringReader).readObject();
        return new Mensagem(jsonObject);
    }

    @Override
    public boolean willDecode(String s) {
        try {
            decode(s);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
}
