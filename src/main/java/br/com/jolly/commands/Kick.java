package br.com.jolly.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("kick")){
            Member membro = event.getOption("user").getAsMember();
            event.getGuild().kick(membro).queue();
            event.reply("O Usuario " + membro.getAsMention() + " Foi expulso com sucesso!").queue();
        }
    }
    
    
}
