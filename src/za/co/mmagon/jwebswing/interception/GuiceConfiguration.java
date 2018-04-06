package za.co.mmagon.jwebswing.interception;

import za.co.mmagon.guiceinjection.GuiceConfig;
import za.co.mmagon.guiceinjection.interfaces.IGuiceConfigurator;

/**
 * Sets the scanner to include all methods
 */
public class GuiceConfiguration
		implements IGuiceConfigurator
{
	@Override
	public GuiceConfig configure(GuiceConfig config)
	{
		return config.setMethodAnnotationIndexing(true)
		             .setIgnoreMethodVisibility(true);
	}
}
