package br.com.jolly.commands;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Gato extends ListenerAdapter{
    String gato;

    public void gatoApi() throws IOException, ParseException{
        URL url = new URL("https://api.thecatapi.com/v1/images/search");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JSONParser jp = new JSONParser();
        JSONArray jArray = (JSONArray) jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JSONObject jObject = (JSONObject) jArray.get(0);
        gato = (String) jObject.get("url");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("gato")){
            try {
                gatoApi();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            event.reply("Admire esse gatinho fofo").setEphemeral(true).queue();
            event.getChannel().sendMessage(gato).queue();
        }
    }


}

