
import com.jwebmp.interception.JWebMPInterceptionBinder;

module com.jwebmp.interception {
	uses com.jwebmp.interception.services.AjaxCallIntercepter;
	uses com.jwebmp.interception.services.DataCallIntercepter;
	uses com.jwebmp.interception.services.SiteCallIntercepter;

	requires transitive com.jwebmp.guicedinjection;

	exports com.jwebmp.interception;
	exports com.jwebmp.interception.services;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder with JWebMPInterceptionBinder;

}
