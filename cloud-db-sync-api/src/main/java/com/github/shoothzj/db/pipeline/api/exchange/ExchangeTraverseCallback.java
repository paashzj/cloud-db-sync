package com.github.shoothzj.db.pipeline.api.exchange;

/**
 * @author hezhangjian
 */
@FunctionalInterface
public interface ExchangeTraverseCallback {

    void callback(String name, AbstractExchange abstractExchange);

}
