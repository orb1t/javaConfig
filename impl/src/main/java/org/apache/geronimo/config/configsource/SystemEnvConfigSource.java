/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.geronimo.config.configsource;


import javx.config.spi.ConfigSource;

import java.util.Map;

/**
 * {@link ConfigSource} which uses {@link System#getenv()}
 * <p>
 * We also allow to write underlines _ instead of dots _ in the
 * environment via export (unix) or SET (windows)
 *
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
public class SystemEnvConfigSource implements ConfigSource {
    private Map<String, String> configValues;

    public SystemEnvConfigSource() {
        configValues = System.getenv();
    }

    @Override
    public String getConfigName() {
        return ConfigSource.class.getPackage().getName() + ".environment";
    }

    @Override
    public String getPropertyValue(String key) {
        String val = configValues.get(key);
        if (val == null || val.isEmpty()) {
            val = configValues.get(key.replace('.', '_'));
        }

        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemEnvConfigSource that = (SystemEnvConfigSource) o;

        return configValues.equals(that.configValues);

    }

    @Override
    public int hashCode() {
        return configValues.hashCode();
    }
}
