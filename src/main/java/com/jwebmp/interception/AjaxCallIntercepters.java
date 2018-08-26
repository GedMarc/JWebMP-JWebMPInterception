/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.interception;

import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.logger.LogFactory;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
class AjaxCallIntercepters
		implements org.aopalliance.intercept.MethodInterceptor
{

	private static final Logger LOG = LogFactory.getLog(AjaxCallIntercepters.class.getName());

	/*
	 * Constructs a new AjaxCallIntercepters
	 */
	public AjaxCallIntercepters()
	{
		//Nothing needed
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		AjaxCallIntercepters.LOG.finer("Intercepting Ajax Call");
		for (Class<? extends AjaxCallIntercepter> siClass : GuiceContext.reflect()
		                                                                .getSubTypesOf(AjaxCallIntercepter.class))
		{
			if (siClass.isInterface())
			{
				continue;
			}
			AjaxCallIntercepter si = GuiceContext.inject()
			                                     .getInstance(siClass);
			AjaxCallIntercepters.LOG.log(Level.FINER, "Ajax Call Interception Occuring : {0}", siClass.getCanonicalName());
			si.intercept();
		}
		AjaxCallIntercepters.LOG.finer("Interception for Ajax Call Complete");
		return invocation.proceed();
	}
}
