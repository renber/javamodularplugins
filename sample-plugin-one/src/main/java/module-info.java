import de.renebergelt.java.playground.modules.pluginsystem.core.attributes.ModuleVersion;

@ModuleVersion("1.0")
module de.renebergelt.java.playground.modules.pluginsystem.plugins.samplepluginone {

    requires de.renebergelt.java.playground.modules.pluginsystem.core;

    exports de.renebergelt.java.playground.modules.pluginsystem.plugins.samplepluginone;

    // this module contains one Plugin: PluginOne
    provides de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo
             with de.renebergelt.java.playground.modules.pluginsystem.plugins.samplepluginone.PluginOneInfo;
}