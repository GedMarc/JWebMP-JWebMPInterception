import com.jwebmp.guicedinjection.interfaces.IGuiceConfigurator;
import com.jwebmp.interception.IGuiceConfiguration;

module com.jwebmp.interception{
	requires com.jwebmp.guicedinjection;

	exports com.jwebmp.interception;
	exports com.jwebmp.interception.interfaces;

	provides IGuiceConfigurator with IGuiceConfiguration;
}
