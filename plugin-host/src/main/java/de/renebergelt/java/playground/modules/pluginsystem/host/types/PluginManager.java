package de.renebergelt.java.playground.modules.pluginsystem.host.types;

import de.renebergelt.java.playground.modules.pluginsystem.core.Plugin;
import de.renebergelt.java.playground.modules.pluginsystem.core.PluginInfo;
import de.renebergelt.java.playground.modules.pluginsystem.core.attributes.ModuleVersion;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * Manages plugins
 */
public class PluginManager {

    private List<LoadedPlugin> loadedPlugins = new ArrayList<>();

    public List<LoadedPlugin> getLoadedPlugins() {
        return loadedPlugins;
    }

    public void discoverPlugins() {

        // discover integrated plugins
        System.out.println("Internal plugins: ");
        for (PluginInfo pInfo: ServiceLoader.load(ModuleLayer.boot(), PluginInfo.class)) {
            readPluginInfo(pInfo, true);
        }

        // load external plugins
        String pluginDir = System.getProperty("user.dir") + "/plugin-host/plugins";

        // find all modules in the plugins directory
        for (ModuleReference mr : ModuleFinder.of(Paths.get(pluginDir)).findAll()) {
            System.out.println("Found module: " + mr.descriptor().name());

                // instantiate module classes in an own layer
                ModuleLayer layer = createLayer(mr);
                for (PluginInfo pInfo : ServiceLoader.load(layer, PluginInfo.class)) {
                    // as the ModuleLayer has boot as parent it also reports
                    // internal modules -> filter these (they are loaded by a different/new classloader)
                    if (pInfo.getClass().getClassLoader() != this.getClass().getClassLoader()) {
                        readPluginInfo(pInfo, false);
                    }
                }
            }
    }

    private void readPluginInfo(PluginInfo pInfo, boolean internal) {
        Module module = pInfo.getClass().getModule();

        System.out.println("    " + pInfo.getName() +
                " V" + pInfo.getVersion() +
                " from " + (internal ? "internal" : "external") +
                " module " + module.getName() + " V " + getModuleVersion(module));

        LoadedPlugin lp = loadPlugin(pInfo);
        if (lp != null)
            loadedPlugins.add(lp);
    }

    private String getModuleVersion(Module module) {
        ModuleVersion v = module.getAnnotation(ModuleVersion.class);
        if (v == null)
            return "?";

        return v.value();
    }

    private LoadedPlugin loadPlugin(PluginInfo pluginInfo) {
        try {
            Plugin pInstance = pluginInfo.getPluginClass().getDeclaredConstructor().newInstance();
            return  new LoadedPlugin(pluginInfo, pInstance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create a ModuleLayer for the given module reference
     */
    private static ModuleLayer createLayer(ModuleReference moduleReference) {
        try {
            String path = moduleReference.location().get().toURL().getFile().substring(1);

            final ModuleFinder finder = ModuleFinder.of(Paths.get(path));
            final ModuleLayer parent = ModuleLayer.boot();
            final Configuration config = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of(moduleReference.descriptor().name()));
            return parent.defineModulesWithOneLoader(config, ClassLoader.getSystemClassLoader());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
