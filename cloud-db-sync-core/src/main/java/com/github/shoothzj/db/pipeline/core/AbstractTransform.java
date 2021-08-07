package com.github.shoothzj.db.pipeline.core;

import com.github.shoothzj.db.pipeline.api.exchange.MapExchange;
import com.github.shoothzj.db.pipeline.api.module.transform.MapDto;
import com.github.shoothzj.db.pipeline.api.module.transform.TransformDto;
import com.github.shoothzj.db.pipeline.core.util.ExchangeCalculateUtil;
import com.github.shoothzj.db.pipeline.core.util.MapExchangeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author hezhangjian
 */
public class AbstractTransform {

    protected MapExchange transform(MapExchange mapExchange, TransformDto transformDto) {
        final List<MapDto> mapDtoList = transformDto.getMap();
        final MapExchange resultExchange = new MapExchange();
        for (MapDto mapDto : mapDtoList) {
            final String fieldName = mapDto.getFieldName();
            final Object processMap = ExchangeCalculateUtil.processMap(mapExchange.getExchange(fieldName), mapDto);
            String auxName = StringUtils.isNotEmpty(mapDto.getReName()) ? mapDto.getReName() : mapDto.getFieldName();
            MapExchangeUtil.putVal(resultExchange, auxName, processMap);
        }
        return resultExchange;
    }

}
