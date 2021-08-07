package com.github.shoothzj.db.pipeline.core.mapper;

import com.github.shoothzj.db.pipeline.api.exchange.MapExchange;

/**
 * @author hezhangjian
 */
public abstract class AbstractGenericMapper<T> {

    public abstract T map2Generic(MapExchange mapExchange);

}
