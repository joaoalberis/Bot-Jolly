package br.com.jolly.commands;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Dog extends ListenerAdapter{
    String dog;
    public void dogApi() throws IOException, ParseException{
        URL url = new URL("https://dog.ceo/api/breeds/image/random");
        HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
        request.connect();

        JSONObject jsonObject;

        JSONParser jp = new JSONParser();
        jsonObject = (JSONObject) jp.parse(new InputStreamReader((InputStream) request.getContent()));
        
        dog = (String) jsonObject.get("message");


    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("cachorro")){
            try {
                dogApi();
            }catch(IOException e){
                e.printStackTrace();
            }catch(ParseException e){
                e.printStackTrace();
            }

            
            event.reply("aqui está seu dog fofin").setEphemeral(true).queue();
            event.getChannel().sendMessage(dog).queue();
        }
    }

    
    
}
