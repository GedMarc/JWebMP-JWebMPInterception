import com.jwebmp.interception.JWebMPGuiceContextConfig;

module com.jwebmp.interception{
	requires com.jwebmp.guicedinjection;

	exports com.jwebmp.interception;
	exports com.jwebmp.interception.interfaces;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceConfigurator with JWebMPGuiceContextConfig;
}
