/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.geronimo.config.tck.configsources;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javx.config.spi.ConfigSource;
import javx.config.spi.ConfigSourceProvider;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public class CustomConfigSourceProvider implements ConfigSourceProvider {
    @Override
    public Iterable<SourceConfiguration> getConfigSources(ClassLoader forClassLoader) {
        List<SourceConfiguration> detectedConfigSources = new ArrayList<>();

        final Enumeration<URL> yamlFiles;
        try {
            yamlFiles = forClassLoader.getResources("sampleconfig.yaml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (yamlFiles.hasMoreElements()) {
            final URL url = yamlFiles.nextElement();
            detectedConfigSources.add(new SourceConfiguration() {
                @Override
                public ConfigSource source() {
                    return new SampleYamlConfigSource(url);
                }

                @Override
                public int ordinal() {
                    return 110;
                }
            });
        }
        return detectedConfigSources;
    }
}
