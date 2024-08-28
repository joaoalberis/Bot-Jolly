package br.com.jolly.commands;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.jolly.events.Traducao;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FrasesNorris extends ListenerAdapter{
    String frases;

    public void norrisApi() throws IOException, ParseException, InterruptedException{
        URL url = new URL("https://api.chucknorris.io/jokes/random");
        HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
        request.connect();

        JSONObject jsonObject;

        JSONParser jp = new JSONParser();
        jsonObject = (JSONObject) jp.parse(new InputStreamReader((InputStream) request.getContent()));
        String norris = (String) jsonObject.get("value");
        

        frases = norris;

    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("chucknorris")){
            try {
                norrisApi();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            event.reply(frases).setEphemeral(false).queue();
            
        }
    }

    
}
