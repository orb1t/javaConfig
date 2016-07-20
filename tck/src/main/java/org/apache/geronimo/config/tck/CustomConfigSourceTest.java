package org.apache.geronimo.config.tck;

import javx.config.Config;
import javx.config.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
public class CustomConfigSourceTest {

    @Test
    public void testConfigSourceProvider() {
        Config config = ConfigFactory.getConfig();

        Assert.assertEquals(config.getValue("tck.config.test.customDbConfig.key1"), "valueFromDb1");
    }
}
