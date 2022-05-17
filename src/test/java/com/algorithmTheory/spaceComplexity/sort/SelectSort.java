package com.algorithmTheory.spaceComplexity.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
class SelectSort {

    ArrayList<Integer> data = new ArrayList<>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 10; i++) {
            data.add((int) (Math.random() * 10));
        }
        List<Integer> collect = data.stream().distinct().collect(Collectors.toList());
        data = (ArrayList<Integer>) collect;
    }

    @Test
    @DisplayName("선택 정렬")
    void selectionSort() {
        int min;
        for (int i = 0; i < data.size() - 1; i++) {
            min = i; // 핵심 2. min 의 역할은 핵심 1 에서 끝났어. 초기화를 해주고 다시 min 의 역할을 하게할꺼야.
            for (int j = i + 1; j < data.size(); j++) {
                if(data.get(min) > data.get(j)) {
                    min = j; // 핵심 1. 여기까지 왔다는건 data[index] 번째의 값 보다 작은 얘 가 조건에 걸린것이므로, 해당 데이터의 인덱스를 min 에 담아두겠다 는 거거덩.
                }
            }
            Collections.swap(data, min, i);
        }
        log.info("data={}", data);
    }
}
