package com.anserx.yqcoding.common.format;

import com.anserx.yqcoding.common.annotation.Desensitization;
import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class DesensitizedAnnotationFormatterFactory extends EmbeddedValueResolutionSupport implements AnnotationFormatterFactory<Desensitization> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> hashSet = new HashSet<>();
        hashSet.add(String.class);
        return hashSet;
    }

    @Override
    public Printer<?> getPrinter(Desensitization annotation, Class<?> fieldType) {
        return getFormatter(annotation);
    }

    @Override
    public Parser<?> getParser(Desensitization annotation, Class<?> fieldType) {
        return getFormatter(annotation);
    }

    private DesensitizedFormatter getFormatter(Desensitization desensitized) {
        DesensitizedFormatter formatter = new DesensitizedFormatter();
        formatter.setTypeEnum(desensitized.type());
        return formatter;
    }
}
