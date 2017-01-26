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
package io.microprofile.config.internal;

import io.microprofile.config.Config;
import io.microprofile.config.spi.ConfigSource;
import io.microprofile.config.spi.Converter;

/**
 * Builder for manually creating an instance of a {@code Config}.
 */
public class ConfigBuilder {
    public ConfigBuilder ignoreDefaultSources() {
        //X TODO
        return null;
    }

    public ConfigBuilder forClassLoader(ClassLoader loader) {
        //X TODO
        return null;
    }

    public ConfigBuilder withSources(ConfigSource... sources) {
        //X TODO
        return null;
    }

    public ConfigBuilder withConverters(Converter<?>[] filters) {
        //X TODO
        return null;
    }

    public Config build() {
        //X TODO
        return null;
    }
}
