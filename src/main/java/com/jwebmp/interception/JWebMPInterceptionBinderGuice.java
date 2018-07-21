package com.jwebmp.interception;

import com.google.inject.matcher.Matchers;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.logger.LogFactory;

public class JWebMPInterceptionBinderGuice
		implements IGuiceDefaultBinder<GuiceInjectorModule>
{
	private static final java.util.logging.Logger log = LogFactory.getLog("JWebMPInterceptionBinding");

	@Override
	public void onBind(GuiceInjectorModule module)
	{
		log.fine("Bound Intercepter @SiteInterception");
		module.bindInterceptor(Matchers.any(), Matchers.annotatedWith(SiteInterception.class), new SiteIntercepters());
		log.fine("Bound Intercepter @AjaxCallInterception");
		module.bindInterceptor(Matchers.any(), Matchers.annotatedWith(AjaxCallInterception.class), new AjaxCallIntercepters());
		log.fine("Bound Intercepter @DataCallInterception");
		module.bindInterceptor(Matchers.any(), Matchers.annotatedWith(DataCallInterception.class), new DataCallIntercepters());
	}
}
