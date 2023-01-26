package br.com.jolly.commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.UnicodeEmoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CriarSorteio extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("sorteio")){
            String tempo = event.getOption("tempo").getAsString();
            if (tempo.matches("^[0-9]+(d|m|a|h|M|s)$")){
                String ganhadores = event.getOption("ganhadores").getAsString();
                String titulo = event.getOption("titulo").getAsString();
                String desc = event.getOption("descricao").getAsString();
                desc = desc.replace("\\n", "\n");
                Channel canal = event.getOption("canal").getAsChannel();
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(Color.decode("#8A2BE2"));
                embed.setTitle(titulo);
                embed.setDescription(desc);
                embed.addField("Duração: " + tempo, "Ganhadores: " + ganhadores, false);
                if(canal.getType().isMessage()){
                    Message teste = event.getGuild().getTextChannelById(canal.getIdLong()).sendMessageEmbeds(embed.build()).complete();
                    Emoji emote = Emoji.fromUnicode("U+1F389");
                    teste.addReaction(emote).queue();
                    long testeid = teste.getIdLong();
                    System.out.println(testeid);
                    event.reply("teste").setEphemeral(true).queue();
                }else{
                    event.reply("Escolha um canal que seja de texto!").setEphemeral(true).queue();
                }
            }else{
                event.reply("O tempo setado não corresponde a nenhum disponivel.").setEphemeral(true).queue();
            }
            
        }
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        String emoji = event.getReaction().getEmoji().asUnicode().getAsCodepoints();
        System.out.println(emoji);
        if (emoji.equals("U+1f389")){
            if (event.getUser().isBot()) return;
            String joao = event.getMember().getAsMention();
            event.getChannel().sendMessage("Entrou no sorteio: " + joao).queue();
            long emojis = event.getReaction().getMessageIdLong();
            System.out.println(emojis);
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        String emoji = event.getReaction().getEmoji().asUnicode().getAsCodepoints();
        System.out.println(emoji);
        if (emoji.equals("U+1f389")){
            if (event.getUser().isBot()) return;
            String joao = event.getMember().getAsMention();
            event.getChannel().sendMessage("Saiu do sorteio: " + joao).queue();
            long emojis = event.getReaction().getMessageIdLong();
            System.out.println(emojis);
        }
    }
        
    
    
}
