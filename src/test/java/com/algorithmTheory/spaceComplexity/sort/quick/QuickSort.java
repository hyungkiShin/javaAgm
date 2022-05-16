package com.algorithmTheory.spaceComplexity.sort.quick;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
class QuickSort {

    ArrayList<Integer> dataList = new ArrayList<Integer>(Arrays.asList(4,2,1,7,5));

    @Test
    @DisplayName("QuickSort")
    void quickSort() {
        final ArrayList<Integer> sort = quickSort(dataList);
        System.out.println("sort = " + sort);
    }

    public ArrayList<Integer> quickSort(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0); // 5

        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();

        for (int index = 1; index < dataList.size(); index++) {
            if(dataList.get(index) > pivot) { // 5 > 5
                rightList.add(dataList.get(index));
            } else { // 0
                leftList.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.quickSort(leftList));
        mergedArr.addAll(List.of(pivot));
        mergedArr.addAll(this.quickSort(rightList));

        log.info("leftList={}", leftList);
        log.info("pivot", pivot);
        log.info("rightList={}", rightList);
        log.info("mergedArr={}", mergedArr);
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        return mergedArr;
    }
}
