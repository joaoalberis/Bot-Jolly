package br.com.jolly.commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class profile extends ListenerAdapter{

    String mess;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("server-info")){
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(event.getGuild().getName());
            embed.setColor(Color.CYAN);
            embed.addField("🆔 Id", "```" + event.getGuild().getId() + "```", true);
            embed.addField("👨‍💼 Usuarios", "```" +  event.getGuild().getMemberCount() + " Usuarios```", true);
            embed.addField("📂 Canais: " + event.getGuild().getChannels().size(), "#️⃣ Texto: " + event.getGuild().getTextChannels().size() + "\n🔊 Voz: " + event.getGuild().getVoiceChannels().size(), true);
            int ano = event.getGuild().getTimeCreated().getYear();
            int mes = event.getGuild().getTimeCreated().getMonth().getValue();
            mess(mes);
            int dia = event.getGuild().getTimeCreated().getDayOfMonth();
            embed.addField("📆 Servidor Criado", dia + " de " + mess + " de " + ano , true);
            ano = event.getGuild().getMember(event.getUser()).getTimeJoined().getYear();
            mes = event.getGuild().getMember(event.getUser()).getTimeJoined().getMonth().getValue();
            dia = event.getGuild().getMember(event.getUser()).getTimeJoined().getDayOfMonth();
            mess(mes);
            embed.addField("📌 " + event.getUser().getName() + " entrou em", dia + " de " + mess + " de " + ano, true);
            embed.addField("💎 Criador", event.getGuild().getOwner().getUser().getAsMention(), true);
            embed.setThumbnail(event.getGuild().getIconUrl()).setImage("https://media.tenor.com/n2fnv0PQHCYAAAAM/avdf.gif");
            event.replyEmbeds(embed.build()).queue();
        }

    }

    private void mess(int mes) {
        switch (mes){
            case 1:
                mess = "Janeiro";
                break;
            case 2:
                mess = "Fevereiro";
                break;
            case 3:
                mess = "Março";
                break;
            case 4:
                mess = "Abril";
                break;
            case 5:
                mess = "Maio";
                break;
            case 6:
                mess = "Junho";
                break;
            case 7:
                mess = "Julho";
                break;
            case 8:
                mess = "Agosto";
                break;
            case 9:
                mess = "Setembro";
                break;
            case 10:
                mess = "Outubro";
                break;
            case 11:
                mess = "Novembro";
                break;
            case 12:
                mess = "Dezembro";
                break;
        }
    }
    
    
}
