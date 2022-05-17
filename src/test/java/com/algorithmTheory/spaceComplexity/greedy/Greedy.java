package com.algorithmTheory.spaceComplexity.greedy;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
