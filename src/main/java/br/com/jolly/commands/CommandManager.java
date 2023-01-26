package br.com.jolly.commands;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class CommandManager extends ListenerAdapter{

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        commandData.add(Commands.slash("ban", "Bana um usuario de seu servidor")
        .addOption(OptionType.USER, "user", "Marque o usuario a ser expulso", true)
        .addOption(OptionType.STRING, "razao", "Diga a razão pelo qual o player será banido!")
        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)));
        commandData.add(Commands.slash("kick", "Expulse um usuario de seu servidor")
        .addOption(OptionType.USER, "user", "Marque o usuario a ser expulso", true)
        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)));
        commandData.add(Commands.slash("sugestao", "use para mandar uma sugestão para o servidor!")
        .addOption(OptionType.STRING, "ideia", "Digite aqui a sugestão que você tem. OBS: caso queira pular linha bote o caractere |", true));

        commandData.add(Commands.slash("sorteio", "Use para criar um sorteio")
        .addOption(OptionType.CHANNEL, "canal", "Escolha o canal que será feito o sorteio", true)
        .addOption(OptionType.STRING, "titulo", "Digite o titulo do sorteio", true)
        .addOption(OptionType.STRING, "descricao", "Digite a descrição de seu sorteio", true)
        .addOption(OptionType.INTEGER, "ganhadores", "Digite quantos ganhadores terá", true)
        .addOption(OptionType.STRING, "tempo", "Digite o tempo de duração(ex: 1m, 1h, 1d)", true));

        commandData.add(Commands.slash("gato", "Irá retornar uma foto de uma gato fofo"));
        commandData.add(Commands.slash("cachorro", "Irá retornar uma foto de uma cachorro fofo"));
        commandData.add(Commands.slash("server-info", "Informações sobre o servidor"));
        commandData.add(Commands.slash("avatar-user", "Veja o avatar de um usuario")
        .addOption(OptionType.USER, "user", "Escolha um usuario para ver o avatars", true));

        commandData.add(Commands.slash("caracoroa", "Tente a sorte!")
        .addOption(OptionType.STRING, "moeda", "Escolha cara ou coroa", true, true));

        commandData.add(Commands.slash("conselhos", "Receba um conselho"));
        
        commandData.add(Commands.slash("chucknorris", "Recebe uma frase falada pelo chuck norris"));

        event.getGuild().updateCommands().addCommands(commandData).queue();
        
        
        


    }

    
    
    
}
