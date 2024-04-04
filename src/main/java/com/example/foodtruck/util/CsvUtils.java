package com.example.foodtruck.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.util.List;

@UtilityClass
public class CsvUtils {

    private static final CsvMapper CSV_MAPPER = new CsvMapper();

    @SneakyThrows
    public static <T> List<T> parse(InputStream inputStream, Class<T> type) {
        MappingIterator<T> iterator = readerFor(type).readValues(inputStream);
        return iterator.readAll();
    }

    private static <T> ObjectReader readerFor(Class<T> type) {
        var bootstrapSchema = CsvSchema.emptySchema().withHeader();
        return CSV_MAPPER.readerFor(type).with(bootstrapSchema);
    }
}
