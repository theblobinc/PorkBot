/*
 * Adapted from the Wizardry License
 *
 * Copyright (c) 2016-2018 DaPorkchop_
 *
 * Permission is hereby granted to any persons and/or organizations using this software to copy, modify, merge, publish, and distribute it.
 * Said persons and/or organizations are not allowed to use the software or any derivatives of the work for commercial use or any other means to generate income, nor are they allowed to claim this software as their own.
 *
 * The persons and/or organizations are also disallowed from sub-licensing and/or trademarking this software without explicit permission from DaPorkchop_.
 *
 * Any persons and/or organizations using this software must disclose their source code and have it publicly available, include this license, provide sufficient credit to the original authors of the project (IE: DaPorkchop_), as well as provide a link to the original project.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package net.daporkchop.porkbot.command.minecraft;

import net.daporkchop.porkbot.command.Command;
import net.daporkchop.porkbot.util.MessageUtils;
import net.daporkchop.porkbot.util.UUIDFetcher;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandMcUUID extends Command {

    public CommandMcUUID() {
        super("mcuuid");
    }

    @Override
    public void execute(MessageReceivedEvent evt, String[] args, String message) {
        if (args.length < 2 || args[1].isEmpty()) {
            sendErrorMessage(evt.getTextChannel(), "Name isn't long enough or isn't given!");
            return;
        }

        UUIDFetcher.enqueueRequest(args[1], uuid -> {
            if (uuid == null) {
                MessageUtils.sendMessage("Player " + args[1] + " could not be found! Are they a payed PC user?", evt.getTextChannel());
            } else {
                MessageUtils.sendMessage(args[1] + "'s UUID:\n```\n" + UUIDFetcher.getUUID(uuid).toString() + "\n```", evt.getTextChannel());
            }
        });
    }

    @Override
    public String getUsage() {
        return "..mcuuid <username>";
    }

    @Override
    public String getUsageExample() {
        return "..mcuuid Notch";
    }
}
