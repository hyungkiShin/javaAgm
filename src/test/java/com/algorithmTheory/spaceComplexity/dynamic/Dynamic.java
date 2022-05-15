package com.algorithmTheory.spaceComplexity.dynamic;

public class Dynamic {

    /*
     * 시간복잡도를 높히기 위한 기법들은 공간 복잡도를 희생 시킬 수 있다.
     * "*" 부분
     */
    public int dynamicFunc(int data) {
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0; // "*"
        cache[1] = 1; // "*"
        for (int index = 2; index < data + 1; index++) {
            cache[index] = cache[index - 1] + cache[index -2];
        }
        return cache[data];
    }


}
