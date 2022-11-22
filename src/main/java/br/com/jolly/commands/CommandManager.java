package br.com.jolly.commands;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class CommandManager extends ListenerAdapter{

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        commandData.add(Commands.slash("gato", "Irá retornar uma foto de uma gato fofo"));
        commandData.add(Commands.slash("cachorro", "Irá retornar uma foto de uma cachorro fofo"));
        commandData.add(Commands.slash("server-info", "Informações sobre o servidor"));

        event.getGuild().updateCommands().addCommands(commandData).queue();
        
        
        


    }

    
    
    
}
