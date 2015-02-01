package dk.pointless.canarybasics;

import net.canarymod.chat.Colors;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.plugin.PluginListener;

public class CanaryBasicsListener implements PluginListener {
	
	@HookHandler
	public void onLogin(ConnectionHook hook)
	{
		hook.getPlayer().message(Colors.YELLOW + "Hello" + hook.getPlayer().getName());
	}

}
