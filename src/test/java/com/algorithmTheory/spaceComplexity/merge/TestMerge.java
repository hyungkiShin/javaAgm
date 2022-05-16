package com.algorithmTheory.spaceComplexity.merge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
class TestMerge {

    ArrayList<Integer> dataList = new ArrayList<Integer>(Arrays.asList(4,3,2,1));

    @Test
    @DisplayName("mergeSortTest")
    void mergeSortTest() {
        final ArrayList<Integer> sortList = splitList(dataList);
        log.info("sortList={}", sortList);
    }

    private ArrayList<Integer> splitList(final ArrayList<Integer> dataList) {

        if (dataList.size() <= 1) {
            return dataList;
        }
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int mediumIndex = dataList.size() / 2;

        leftList = splitList(new ArrayList<Integer>(dataList.subList(0, mediumIndex)));
        rightList = splitList(new ArrayList<Integer>(dataList.subList(mediumIndex, dataList.size())));

        return mergeSortFunc(leftList, rightList);
    }

    private ArrayList<Integer> mergeSortFunc(final ArrayList<Integer> leftList, final ArrayList<Integer> rightList) {

        ArrayList<Integer> mergeList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergeList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergeList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        while (leftList.size() > leftPoint) {
            mergeList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        while (rightList.size() > rightPoint) {
            mergeList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergeList;
    }
}
