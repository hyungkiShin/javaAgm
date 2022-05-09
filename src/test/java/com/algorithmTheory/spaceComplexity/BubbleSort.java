package com.algorithmTheory.spaceComplexity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BubbleSort {

    /*
     * ### 0. 알고리즘 연습 방법
     * * 알고리즘을 잘 작성하기 위해서는 잘 작성된 알고리즘을 이해하고, 스스로 만들어봐야 함
     *   - 모사! 그림을 잘 그리기 위해서는 잘 그린 그림을 모방하는 것부터 시작
     *
     * > 이번 챕터부터 알고리즘 시작입니다.!
     */

    /*
     * ### 1. 정렬 (sorting) 이란?
     * - 정렬 (sorting): 어떤 데이터들이 주어졌을 때 이를 정해진 순서대로 나열하는 것
     * - 정렬은 프로그램 작성시 빈번하게 필요로 함
     * - 다양한 알고리즘이 고안되었으며, 알고리즘 학습의 필수
     *
     * > 다양한 정렬 알고리즘 이해를 통해, 동일한 문제에 대해 다양한 알고리즘이 고안될 수 있음을 이해하고,
     * > 각 알고리즘간 성능 비교를 통해, 알고리즘 성능 분석에 대해서도 이해할 수 있음
     */

    ArrayList<Integer> data = new ArrayList<Integer>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 100; i++) {
            data.add((int)(Math.random() * 100));
        }
    }

    @Test
    void old_bubble() {
        int [] arr = { 5, 4, 3, 2, 1, 9, 10 };
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(arr[j-1] > arr[j]) {
                    log.info("arr[j-1]={} , arr[j]={}",arr[j-1], arr[j]);
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        log.info("arr={}", arr);
    }

    @Test
    void new_Bubble() {
        for (int index = 0; index < data.size() - 1; index++) {
            boolean swap = false;

            for (int index2 = 0; index2 < data.size() - 1; index2++) {
                if(data.get(index2) > data.get(index2 + 1)) {
                    Collections.swap(data, index2, index2 + 1);
                    swap = true;
                }
            }
            if(!swap) break;
        }
        log.info("data={}", data);
    }

}
