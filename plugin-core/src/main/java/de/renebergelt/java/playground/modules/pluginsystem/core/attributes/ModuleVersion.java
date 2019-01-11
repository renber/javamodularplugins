package de.renebergelt.java.playground.modules.pluginsystem.core.attributes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.MODULE;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={MODULE})
public @interface ModuleVersion {

    String value();

}
