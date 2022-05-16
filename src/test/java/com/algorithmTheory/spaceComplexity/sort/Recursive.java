package com.algorithmTheory.spaceComplexity.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class Recursive {

    public static int recursive (int n) {
        if(n < 1) return n;
        return n * recursive(n -1);
    }

    public static int factorialFunc(int data) {
        if (data <= 1) {
            return data;
        }
        return factorialFunc(data - 1) + factorialFunc(data - 2);
    }

    @Test
    void recurTest() {
        int recursive = recursive(3);
        log.info("recursive={}", recursive);
    }

    @Test
    @DisplayName("테스트명")
    void 테스트명() {
        final int i = factorialFunc(10);
        log.info("factorialFunc={}", i);
    }

}
