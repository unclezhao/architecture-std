package me.zy.std.spi.spring.extension;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Strategy to load '.tml' (or '.toml') files into a {@link PropertySource}.
 *
 * @author zhaoyang on 2020-06-23.
 */
public class TomlPropertySourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[] { "tml", "toml" };
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        if (!ClassUtils.isPresent("org.tomlj.Toml", null)) {
            throw new IllegalStateException(
                "Attempted to load " + name + " but tomlj was not found on the classpath");
        }
        TomlParseResult tomlParseResult = Toml.parse(resource.getInputStream());
        Map<String, Object> resultMap = tomlParseResult.toMap();
        if (resultMap.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(new OriginTrackedMapPropertySource(name, resultMap));
    }
}
