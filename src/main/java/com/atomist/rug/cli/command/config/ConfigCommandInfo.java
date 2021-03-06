package com.atomist.rug.cli.command.config;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import com.atomist.rug.cli.command.AbstractRugScopedCommandInfo;

public class ConfigCommandInfo extends AbstractRugScopedCommandInfo {

	public ConfigCommandInfo() {
		super(ConfigCommand.class, "default");
	}

	@Override
	public String description() {
		return "Set default archive";
	}

	@Override
	public String detail() {
		return "ACTION should be save or delete.  ARCHIVE should be a valid archive identifier of form "
				+ "GROUP:ARTIFACT or just GROUP.  At any time those defaults can be overriden by specifying "
				+ "GROUP:ARTIFACT and -a from the command line.";
	}

	@Override
	public Options options() {
		Options options = new Options();
		options.addOption(Option.builder("a").argName("AV").desc("Set default archive version to AV")
				.longOpt("archive-version").hasArg(true).optionalArg(true).build());
		options.addOption(Option.builder("g").desc("Set global or project default archive").longOpt("global")
				.hasArg(false).build());
		return options;
	}

	@Override
	public int order() {
		return 80;
	}

	@Override
	public String usage() {
		return "default [OPTION]... ACTION [ARCHIVE]";
	}
}
