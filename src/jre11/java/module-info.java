module com.jwebmp.interception {
	uses com.jwebmp.interception.services.AjaxCallIntercepter;
	uses com.jwebmp.interception.services.DataCallIntercepter;
	uses com.jwebmp.interception.services.SiteCallIntercepter;


	requires com.guicedee.guicedinjection;
	requires aopalliance;
	requires com.guicedee.logmaster;
	requires java.logging;
	requires com.google.guice;
	requires java.validation;

	exports com.jwebmp.interception;
	exports com.jwebmp.interception.services;

	provides com.guicedee.guicedinjection.interfaces.IGuiceDefaultBinder with com.jwebmp.interception.JWebMPInterceptionBinder;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.interception.implementations.JWebMPInterceptionModuleExclusions;
}
