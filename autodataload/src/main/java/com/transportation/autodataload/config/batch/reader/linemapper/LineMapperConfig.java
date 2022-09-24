package com.transportation.autodataload.config.batch.reader.linemapper;

import org.springframework.batch.item.file.LineMapper;

public interface LineMapperConfig<T> {
    LineMapper<T> lineMapper();
}
