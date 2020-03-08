package com.jwebmp.interception.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JWebMPInterceptionModuleExclusions
		implements IGuiceScanModuleExclusions<JWebMPInterceptionModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.interception");
		return strings;
	}
}
