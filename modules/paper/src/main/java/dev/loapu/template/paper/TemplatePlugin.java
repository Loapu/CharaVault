package dev.loapu.template.paper;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import dev.loapu.template.common.util.SingletonFactory;
import org.bukkit.plugin.java.JavaPlugin;

public class TemplatePlugin extends JavaPlugin
{
	@Override
	public void onLoad()
	{
		SingletonFactory.depositInstance(TemplatePlugin.class, this);
		CommandAPI.onLoad(new CommandAPIBukkitConfig(this).silentLogs(true));
	}
	
	@Override
	public void onEnable()
	{
		CommandAPI.onEnable();
	}
	
	@Override
	public void onDisable()
	{
		CommandAPI.onDisable();
	}
}
