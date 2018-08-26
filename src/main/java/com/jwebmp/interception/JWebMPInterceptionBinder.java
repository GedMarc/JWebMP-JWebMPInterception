package com.jwebmp.interception;

import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.interception.services.DataCallIntercepter;
import com.jwebmp.interception.services.SiteCallIntercepter;
import com.jwebmp.logger.LogFactory;

import java.util.ServiceLoader;
import java.util.Set;

@SuppressWarnings("Convert2Diamond")
public class JWebMPInterceptionBinder
		implements IGuiceDefaultBinder<JWebMPInterceptionBinder, GuiceInjectorModule>
{
	public static final Key<Set<AjaxCallIntercepter>> AjaxCallInterceptorKey = Key.get(new TypeLiteral<Set<AjaxCallIntercepter>>() {});
	public static final Key<Set<DataCallIntercepter>> DataCallInterceptorKey = Key.get(new TypeLiteral<Set<DataCallIntercepter>>() {});
	public static final Key<Set<SiteCallIntercepter>> SiteCallInterceptorKey = Key.get(new TypeLiteral<Set<SiteCallIntercepter>>() {});
	private static final java.util.logging.Logger log = LogFactory.getLog("JWebMPInterceptionBinding");

	@Override
	public void onBind(GuiceInjectorModule module)
	{
		module.bind(JWebMPInterceptionBinder.AjaxCallInterceptorKey)
		      .toProvider(() -> IDefaultService.loaderToSet(ServiceLoader.load(AjaxCallIntercepter.class)))
		      .in(Singleton.class);

		module.bind(JWebMPInterceptionBinder.DataCallInterceptorKey)
		      .toProvider(() -> IDefaultService.loaderToSet(ServiceLoader.load(DataCallIntercepter.class)))
		      .in(Singleton.class);

		module.bind(JWebMPInterceptionBinder.SiteCallInterceptorKey)
		      .toProvider(() -> IDefaultService.loaderToSet(ServiceLoader.load(SiteCallIntercepter.class)))
		      .in(Singleton.class);
	}
}
