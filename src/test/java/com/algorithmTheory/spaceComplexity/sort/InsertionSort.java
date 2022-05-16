package com.algorithmTheory.spaceComplexity.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class InsertionSort {


    List<Integer> data = new ArrayList<>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 10; i++) {
            data.add((int)(Math.random() * 10));
        }
    }

    @Test
    @DisplayName("테스트명")
    void 테스트명() {
        // given
        // when
        // then
        int a[] = new int[4 + 1];
        log.info("a={}",a );

    }

    @Test
    @DisplayName("삽입정렬")
    void 삽입정렬() {
        for (int index = 0; index < data.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if(data.get(index2) < data.get(index2 - 1)) {
                    Collections.swap(data, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        log.info("data={}",data);
    }
}
