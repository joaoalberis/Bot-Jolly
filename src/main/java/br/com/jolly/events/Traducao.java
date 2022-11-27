package br.com.jolly.events;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Traducao {
    public static String tradutorApi(String texto) throws IOException, InterruptedException, ParseException{
        texto = texto.replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://translated-mymemory---translation-memory.p.rapidapi.com/api/get?langpair=en%7Cpt&q=" + texto + "!&mt=1&onlyprivate=0&de=a%40b.c"))
		.header("X-RapidAPI-Key", "d21d7b096cmsh831c8922005a4cdp16535djsn096b770c6af5")
		.header("X-RapidAPI-Host", "translated-mymemory---translation-memory.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        
        JSONObject jObject = new JSONObject();
        JSONParser jp = new JSONParser();
        JSONArray jArray = new JSONArray();

        jObject = (JSONObject) jp.parse(response.body());
        jArray = (JSONArray) jObject.get("matches");
        jObject = (JSONObject) jArray.get(0);



        //System.out.println(jObject);
        return (String) jObject.get("translation");
        /*System.out.println("");
        System.out.println(jArray);*/
    }
}
