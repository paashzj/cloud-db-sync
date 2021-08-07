package com.github.shoothzj.db.pipeline.core.util;

import com.github.shoothzj.db.pipeline.api.exchange.InstantExchange;
import com.github.shoothzj.db.pipeline.api.exchange.IntExchange;
import com.github.shoothzj.db.pipeline.api.exchange.LongExchange;
import com.github.shoothzj.db.pipeline.api.exchange.StringExchange;
import com.github.shoothzj.db.pipeline.api.module.transform.MapDto;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 对Exchange进行计算
 * @author hezhangjian
 */
@Slf4j
public class ExchangeCalculateUtil {

    /**
     * 返回字符串类型，则是字符格式
     * @param source Object类型，需要是满足运算的基本格式
     *               现在支持String类型
     * @param mapDto
     * @return
     */
    public static Object processMap(Object source, MapDto mapDto) {
        if (source == null) {
            return null;
        }
        if (source instanceof IntExchange) {
            IntExchange intExchange = (IntExchange) source;
            return CalculateUtil.processMap(intExchange.intValue(), mapDto);
        }
        if (source instanceof LongExchange) {
            LongExchange longExchange = (LongExchange) source;
            return CalculateUtil.processMap(longExchange.longValue(), mapDto);
        }
        if (source instanceof StringExchange) {
            StringExchange stringExchange = (StringExchange) source;
            return CalculateUtil.processMap(stringExchange.stringValue(), mapDto);
        }
        if (source instanceof InstantExchange) {
            InstantExchange instantExchange = (InstantExchange) source;
            return CalculateUtil.processMap(instantExchange.instantValue(), mapDto);
        }
        throw new IllegalStateException("not implemented yet.");
    }

}
