package com.algorithmTheory.spaceComplexity;

import org.junit.jupiter.api.Test;

public class Factorial {

    /**
     *
     * @param n
     * @return
     * ### 공간 복잡도 예제1
     * - n! 팩토리얼 구하기
     *   - n! = 1 x 2 x ... x n
     * - n의 값에 상관없이 변수 n, 변수 fac, 변수 index 만 필요함
     * - 공간 복잡도는 O(1)
     *
     * > 공간 복잡도 계산은 실제 알고리즘 실행시 사용되는 저장공간을 계산하면 됨
     */
    public int factorialFunc(int n) {
        int fac = 1;
        for (int index = 2; index < n + 1; index++) {
            fac = fac * index;
        }
        return fac;
    }

    @Test
    void factorialFunc_test() {
        final int i = factorialFunc(3);
        System.out.println("i = " + i);
    }

    /**
     *
     * @param n
     * @return
     * ### 공간 복잡도 예제2
     * - n! 팩토리얼 구하기
     *   - n! = 1 x 2 x ... x n
     * - 재귀함수를 사용하였으므로, n에 따라, 변수 n이 n개가 만들어지게 됨
     *   - factorial 함수를 재귀 함수로 1까지 호출하였을 경우, n부터 1까지 스택에 쌓이게 됨
     * - 공간 복잡도는 O(n)
     */
    public int factorialFunc2(int n) {
        if(n > 1) {
            return n * factorialFunc2(n -1);
        }
        return 1;
    }

    @Test
    void factorialFunc_test2() {
        final int i = factorialFunc2(5);
        System.out.println("i = " + i);
    }
}
