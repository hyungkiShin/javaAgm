package com.algorithmTheory.spaceComplexity.greedy;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
class Greedy {

        /*
        * ### 2. 탐욕 알고리즘 예
            ### 문제1: 동전 문제
            - 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
            - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
            - 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택하면 됨
        */

    void coinFunc(Integer price, ArrayList<Integer> coinList) {
        int coinCnt = 0;
        int total = 0;
        ArrayList<Integer> coinCase = new ArrayList<>();

        for (Integer coin : coinList) {
            coinCnt = price / coin; // 동전 몫
            price -= coin * coinCnt; // 원금에서 거슬러줄 동전을 제외한 나머지 금액
            coinCase.add(coinCnt); // 해당 회차에서 저장해야 할 동전의 갯수
            total += coinCnt;
        }
        log.info("coinCase = {}", coinCase);
        log.info("total = {}", total);
    }

    @Test
    @DisplayName("동전 문제")
    void 동전_문제() {
        ArrayList<Integer> coinList = new ArrayList<Integer>(List.of(500,100,50,1));
        coinFunc(4720, coinList);
    }

    /*
     * ### 문제2: 부분 배낭 문제 (Fractional Knapsack Problem)
        - 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
        - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
        - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsack Problem 으로 부름
        - Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 (0/1 Knapsack Problem 으로 부름)
     */

    @Test
    @DisplayName("부분 배낭 문제")
    void 부분_배낭_문제() {
        Integer[][] objectList = { {10,10}, {15,12}, {20,10}, {25,8}, {30,5} };
        knapsackFunc(objectList, 30.0);
    }

    // capacity: 최대 배낭이 가질 수 있는 무게
    void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(final Integer[] o1, final Integer[] o2) {
                return (o2[1]/ o2[0]) - (o1[1]/ o1[0]); // 무게를 가치로 나눠줘야 한다.
            }
        });

        for (final Integer[] integers : objectList) {
            if ((capacity - (double) integers[0] > 0)) {
                capacity -= (double) integers[0];
                totalValue += (double) integers[1];
                log.info("무게 = {}, 가치 = {}", integers[0], integers[1]);
            } else {
                fraction = capacity / (double) integers[0];
                totalValue = (double) integers[1] * fraction;
                log.info("무게 = {}, 가치 = {}, 비율 = {}", integers[0], integers[1], fraction);
                break;
            }
        }
        log.info("총 담을 수 있는 가치 = {}", totalValue);
    }
}
