package com.xiaour.spring.boot.spel;

import org.springframework.expression.ParserContext;

/**
 * @author rtw
 * @since 2024/11/27
 */
public class TemplateParserContext implements ParserContext {
    private final String expressionPrefix;
    private final String expressionSuffix;

    public TemplateParserContext() {
        this("#{", "}");
    }

    public TemplateParserContext(String expressionPrefix, String expressionSuffix) {
        this.expressionPrefix = expressionPrefix;
        this.expressionSuffix = expressionSuffix;
    }

    public final boolean isTemplate() {
        return true;
    }

    public final String getExpressionPrefix() {
        return this.expressionPrefix;
    }

    public final String getExpressionSuffix() {
        return this.expressionSuffix;
    }
}
