package com.transportation.autodataload.config.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;

public interface ReaderConfig<T> {
    public FlatFileItemReader<T> reader();
}
