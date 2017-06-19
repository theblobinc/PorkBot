package net.daporkchop.porkbot.command.base.minecraft;

import net.daporkchop.porkbot.PorkBot;
import net.daporkchop.porkbot.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandMcAvatar extends Command {

    public CommandMcAvatar() {
        super("mcavatar");
    }

    @Override
    public void excecute(MessageReceivedEvent evt, String[] args, String message) {
        try {
            if (args.length < 2 || args[1].isEmpty()) {
                sendErrorMessage(evt.getTextChannel(), "Name isn't given!");
                return;
            }

            EmbedBuilder builder = new EmbedBuilder();
            builder.setImage("attachment://image.png");
            builder.setColor(Color.DARK_GRAY);

            byte[] outBytes = PorkBot.downloadImage("https://crafatar.com/avatars/" + args[1] + "?size=128&overlay");

            builder.addField(args[1] + "'s skin", "", false);

            PorkBot.sendImage(builder, outBytes, "image.png", evt.getTextChannel());
        } catch (Exception e) {
            PorkBot.sendException(e, evt);
        }
    }

    @Override
    public String getUsage() {
        return "..mcavatar <name>";
    }

    @Override
    public String getUsageExample() {
        return "..mcavatar Notch";
    }
}
