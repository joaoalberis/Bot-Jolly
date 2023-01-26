package br.com.jolly.commands;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Sugestao extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("sugestao")){
            String sugestao =  event.getOption("ideia").getAsString();
            sugestao = sugestao.replace("|", "\n");
            Member membro = event.getMember();
            EmbedBuilder embed = new EmbedBuilder();
            DateFormat dateFormat = new SimpleDateFormat("dd hh:mm");
	        Date date = new Date();
            embed.setTitle("Nova Sugestão");
            embed.setColor(Color.green);
            embed.addField("Membro", event.getMember().getAsMention(), false);
            embed.addField("Sugestão", sugestao, false);
            embed.setThumbnail(membro.getEffectiveAvatarUrl());
            embed.setFooter(dateFormat.format(date));
            TextChannel mensagem = event.getGuild().getTextChannelsByName("sugestoes", true).get(0);
            Message mensage = mensagem.sendMessageEmbeds(embed.build()).complete();
            mensage.addReaction(Emoji.fromUnicode("U+2705")).queue();
            mensage.addReaction(Emoji.fromUnicode("U+274C")).queue();          
            event.reply("Sua sugestão foi enviada!\nPara visualizar ela vá até o chat " + mensagem.getAsMention()).setEphemeral(true).queue();
        }
    }
    
}
