package br.com.jolly.commands;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;

public class CaraCoroa extends ListenerAdapter{

    private String[] words = new String[]{"cara", "coroa"};

    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        if (event.getName().equals("caracoroa") && event.getFocusedOption().getName().equals("moeda")) {
            List<Command.Choice> options = Stream.of(words)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue()))
                    .map(word -> new Command.Choice(word, word))
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("caracoroa")){
            float valor = (float) Math.random();
            switch (Math.round(valor)){
                case 0:
                    if (event.getOption("moeda").getAsString().equals("coroa")){
                        event.reply("Parabens, você acertou").setEphemeral(false).complete();
                    }else if(event.getOption("moeda").getAsString().equals("cara")){
                        event.reply("Você não acertou dessa vez, tente novamente!").setEphemeral(false).queue();
                    }
                    break;
                case 1:
                    if (event.getOption("moeda").getAsString().equals("cara")){
                        event.reply("Parabens, Você acertou").setEphemeral(false).queue();
                    }else if(event.getOption("moeda").getAsString().equals("coroa")){
                        event.reply("Você não acertou dessa vez, tente novamente!").setEphemeral(false).queue();
                    }
                    break;
            }
        }
    }
        
}
