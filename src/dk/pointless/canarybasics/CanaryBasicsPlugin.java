package dk.pointless.canarybasics;

import net.canarymod.Canary;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.logger.Logman;
import net.canarymod.plugin.Plugin;

public class CanaryBasicsPlugin extends Plugin {

	@Override
	public void disable() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean enable() {
		Logman logger = getLogman();
		logger.info("Enabling "+getName()+" Version " + getVersion());
		Canary.hooks().registerListener(new CanaryBasicsListener(), this);
		try {
			Canary.commands().registerCommands(new CanaryBasicsCommandListener(), this, false);
		} catch (CommandDependencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
