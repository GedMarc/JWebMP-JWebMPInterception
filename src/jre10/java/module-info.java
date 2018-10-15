
import com.jwebmp.interception.JWebMPInterceptionBinder;

module com.jwebmp.interception {
	uses com.jwebmp.interception.services.AjaxCallIntercepter;
	uses com.jwebmp.interception.services.DataCallIntercepter;
	uses com.jwebmp.interception.services.SiteCallIntercepter;


	requires com.jwebmp.guicedinjection;
	requires aopalliance;
	requires com.jwebmp.logmaster;
	requires java.logging;
	requires com.google.guice;
	requires java.validation;

	exports com.jwebmp.interception;
	exports com.jwebmp.interception.services;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder with JWebMPInterceptionBinder;

}
