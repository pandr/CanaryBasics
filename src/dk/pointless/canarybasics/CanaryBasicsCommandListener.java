package dk.pointless.canarybasics;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;

public class CanaryBasicsCommandListener implements CommandListener {

	
	@Command(
			aliases = "nick",
			description = "Set the nickname",
			permissions = { "canarybasics.command.nick" },
			toolTip = "/nick <name>",
			min = 2
			)
	public void nickCommand(MessageReceiver caller, String[] parameters)
	{
		if(caller.getReceiverType().equals(ReceiverType.PLAYER))
		{
			String nickwanted = parameters[1];
			if(nickwanted.equalsIgnoreCase("off"))
			{
				caller.asPlayer().setDisplayName(caller.asPlayer().getName());
			}
			else
			{
				caller.asPlayer().setDisplayName(nickwanted);
			}
			caller.notice("You are now known as: " + caller.asPlayer().getDisplayName());
		}
		else
		{
			caller.notice("No nick for the server");
		}
	}

	@Command(
			aliases = "realname",
			description = "Shows the real name of a player",
			permissions = { "canarybasics.command.realname" },
			toolTip = "/realname <nickname>",
			min = 2
			)
	public void realnameCommand(MessageReceiver caller, String[] parameters)
	{
		String nickwanted = parameters[1];
		for(Player p : Canary.getServer().getConfigurationManager().getAllPlayers())
		{
			if(p.getDisplayName().equalsIgnoreCase(nickwanted))
			{
				caller.message("Real name of " + nickwanted + " is " + p.getName());
				return;
			}
		}
		caller.message("No player with nick " + nickwanted);
	}

}
