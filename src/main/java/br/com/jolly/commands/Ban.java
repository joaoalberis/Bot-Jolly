package br.com.jolly.commands;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ban extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ban")){
            String razao;
            Member membro = event.getOption("user").getAsMember();
            if (event.getOption("razao") != null){
                razao = event.getOption("razao").getAsString();
            }else{
                razao = "Razão não especificada.";
            }
            
            event.getGuild().ban(membro,7, TimeUnit.DAYS).reason(razao + "\nBanido por: " + event.getMember().getEffectiveName()).queue();
            event.reply("O usuario " + membro.getAsMention() + " Foi banido com sucesso!").queue();
        }
    }
    
    
}
