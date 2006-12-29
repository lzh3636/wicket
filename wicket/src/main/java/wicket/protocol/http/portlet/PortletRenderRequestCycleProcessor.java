/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wicket.protocol.http.portlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wicket.request.compound.CompoundRequestCycleProcessor;
import wicket.request.compound.IEventProcessorStrategy;
import wicket.request.compound.IExceptionResponseStrategy;
import wicket.request.compound.IRequestTargetResolverStrategy;

/**
 * A RequestCycleProcessor for portlet render requests. The events are not
 * processed in the render phase.
 * 
 * @see PortletRequestCycle
 * 
 * @author Janne Hietam&auml;ki
 * 
 */
public class PortletRenderRequestCycleProcessor extends CompoundRequestCycleProcessor
{

	/** log. */
	private static final Logger log = LoggerFactory.getLogger(PortletRenderRequestCycleProcessor.class);

	/**
	 * Construct.
	 */
	public PortletRenderRequestCycleProcessor()
	{
		super(new PortletRequestCodingStrategy());
	}

	@Override
	protected IRequestTargetResolverStrategy newRequestTargetResolverStrategy()
	{
		return new PortletRequestTargetResolverStrategy();
	}

	@Override
	protected IEventProcessorStrategy newEventProcessorStrategy()
	{
		return new PortletRenderRequestEventProcessorStrategy();
	}

	@Override
	protected IExceptionResponseStrategy newExceptionResponseStrategy()
	{
		return new PortletExceptionResponseStrategy();
	}		
}