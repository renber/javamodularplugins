package de.renebergelt.java.playground.modules.pluginsystem.host;

import de.renebergelt.java.playground.modules.pluginsystem.host.types.PluginManager;

public class Starter {

    public static void main(String[] args) {

        PluginManager pluginManager = new PluginManager();
        pluginManager.discoverPlugins();

    }
}