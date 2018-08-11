import com.jwebmp.interception.JWebMPGuiceContextConfig;

module com.jwebmp.interception {
	requires com.jwebmp.guicedinjection;
	requires aopalliance;
	requires com.jwebmp.logmaster;
	requires java.logging;
	requires com.google.guice;

	exports com.jwebmp.interception;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceConfigurator with JWebMPGuiceContextConfig;
}
