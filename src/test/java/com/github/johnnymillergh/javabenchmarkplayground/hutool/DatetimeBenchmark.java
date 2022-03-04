package com.github.johnnymillergh.javabenchmarkplayground.hutool;

import cn.hutool.core.date.DateUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openjdk.jmh.annotations.*;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Description: DatetimeBenchmark, change description here.
 *
 * @author Johnny Miller (鍾俊), e-mail: johnnysviva@outlook.com, date: 2/19/2022 12:31 AM
 **/
@Slf4j
@Fork(2)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@BenchmarkMode({Mode.Throughput, Mode.AverageTime})
@OutputTimeUnit(TimeUnit.SECONDS)
public class DatetimeBenchmark {
    @Benchmark
    public void dateUtilParse() {
        for (var i = 0; i < 1000000; i++) {
            DateUtil.parse("2022-01-01T00:00:00.000+08:00");
        }
    }

    @Benchmark
    @SneakyThrows
    public void jdkDate() {
        val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (var i = 0; i < 1000000; i++) {
            sdf.parse("2022-01-01 00:00:00");
        }
    }
}
