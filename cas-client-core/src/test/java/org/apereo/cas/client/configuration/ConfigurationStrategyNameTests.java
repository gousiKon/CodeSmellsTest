/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apereo.cas.client.configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import org.junit.Test;

import static org.junit.Assert.*;

public final class ConfigurationStrategyNameTests {

    @Test
    public void stringToClass() {
        assertEquals(JndiConfigurationStrategyImpl.class, ConfigurationStrategyName.resolveToConfigurationStrategy(ConfigurationStrategyName.JNDI.name()));
        assertEquals(WebXmlConfigurationStrategyImpl.class, ConfigurationStrategyName.resolveToConfigurationStrategy(ConfigurationStrategyName.WEB_XML.name()));
        assertEquals(PropertiesConfigurationStrategyImpl.class, ConfigurationStrategyName.resolveToConfigurationStrategy(ConfigurationStrategyName.PROPERTY_FILE.name()));
        assertEquals(SystemPropertiesConfigurationStrategyImpl.class, ConfigurationStrategyName.resolveToConfigurationStrategy(ConfigurationStrategyName.SYSTEM_PROPERTIES.name()));
        assertEquals(LegacyConfigurationStrategyImpl.class, ConfigurationStrategyName.resolveToConfigurationStrategy(ConfigurationStrategyName.DEFAULT.name()));
        assertEquals(LegacyConfigurationStrategyImpl.class, ConfigurationStrategyName.resolveToConfigurationStrategy("bleh!"));
    }


    @Test
    public void resolveToClass() {
        assertEquals(TestClass.class, ConfigurationStrategyName.resolveToConfigurationStrategy(TestClass.class.getName()));
    }

    private class TestClass extends BaseConfigurationStrategy {

        @Override
        public void init(final FilterConfig filterConfig, final Class<? extends Filter> filterClazz) {

        }

        @Override
        protected String get(final ConfigurationKey configurationKey) {
            return null;
        }
    }
}
