package br.com.jolly.commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CriarSorteio extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("sorteio")){
            String ganhadores = event.getOption("ganhadores").getAsString();
            String tempo = event.getOption("tempo").getAsString();
            String titulo = event.getOption("titulo").getAsString();
            String desc = event.getOption("descricao").getAsString();
            Channel canal = event.getOption("canal").getAsChannel();
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.DARK_GRAY);
            embed.setTitle(titulo);
            embed.setDescription(desc);
            embed.addField("Duração: " + tempo, "Ganhadores: " + ganhadores, false);
            if(canal.getType().isMessage()){
                event.getGuild().getTextChannelById(canal.getIdLong()).sendMessageEmbeds(embed.build()).queue();
                event.reply("teste").setEphemeral(true).queue();
            }else{
                event.reply("Escolha um canal que seja de texto!").setEphemeral(true).queue();
            }
        }
    }
        
    
}
