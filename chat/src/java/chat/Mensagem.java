/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail: bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 *  Json da Mensagem
 */

public class Mensagem {
    
    private JsonObject json;

    public Mensagem(JsonObject json) {
        this.json=json;
    }
    
    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject json) {
        this.json = json;
    }

    @Override
    public String toString() {
        StringWriter writer=new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
    
    
}
