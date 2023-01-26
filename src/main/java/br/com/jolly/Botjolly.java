package br.com.jolly;

import java.util.EnumSet;

import br.com.jolly.commands.AvatarUser;
import br.com.jolly.commands.Ban;
import br.com.jolly.commands.CaraCoroa;
import br.com.jolly.commands.CommandManager;
import br.com.jolly.commands.Conselhos;
import br.com.jolly.commands.CriarSorteio;
import br.com.jolly.commands.Dog;
import br.com.jolly.commands.FrasesNorris;
import br.com.jolly.commands.Gato;
import br.com.jolly.commands.Kick;
import br.com.jolly.commands.Sugestao;
import br.com.jolly.commands.profile;
import br.com.jolly.utils.Env;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Botjolly {
    public static JDA bot;
    public static void main(String[] args) {
        bot = JDABuilder.create(Env.TOKEN, EnumSet.allOf(GatewayIntent.class))
        .setActivity(Activity.playing("Sendo Desenvolvido")).build();

        bot.addEventListener(new Gato());
        bot.addEventListener(new Dog());
        bot.addEventListener(new CommandManager());
        bot.addEventListener(new profile());
        bot.addEventListener(new AvatarUser());
        bot.addEventListener(new CaraCoroa());
        bot.addEventListener(new Conselhos());
        bot.addEventListener(new FrasesNorris());
        bot.addEventListener(new CriarSorteio());
        bot.addEventListener(new Sugestao());
        bot.addEventListener(new Kick());
        bot.addEventListener(new Ban());


        System.out.println("🛰️ - Bot Jolly, em funcionamento.");
    }
}
