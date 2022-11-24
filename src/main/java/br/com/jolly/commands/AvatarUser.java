package br.com.jolly.commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class AvatarUser extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("avatar-user")){
            EmbedBuilder embed = new EmbedBuilder();
            String avatarurl = event.getOption("user").getAsUser().getAvatarUrl();
            embed.setTitle("Avatar de " + event.getOption("user").getAsUser().getName());
            embed.setImage(avatarurl);
            embed.setColor(Color.LIGHT_GRAY);
            event.replyEmbeds(embed.build())
            .addActionRow(Button.link(avatarurl, "Abrir no navegador")).queue();
        }
    }
    
    
}
