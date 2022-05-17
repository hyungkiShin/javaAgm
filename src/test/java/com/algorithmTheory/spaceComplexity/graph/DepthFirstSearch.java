package com.algorithmTheory.spaceComplexity.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
class DepthFirstSearch {

    HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

    @BeforeEach
    void init() {
        graph.put("A", new ArrayList<String>(List.of("B", "C")));
        graph.put("B", new ArrayList<String>(List.of("A", "D")));
        graph.put("C", new ArrayList<String>(List.of("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(List.of("B", "E", "F")));
        graph.put("E", new ArrayList<String>(List.of("D")));
        graph.put("F", new ArrayList<String>(List.of("D")));
        graph.put("G", new ArrayList<String>(List.of("C")));
        graph.put("H", new ArrayList<String>(List.of("C")));
        graph.put("I", new ArrayList<String>(List.of("C", "J")));
        graph.put("J", new ArrayList<String>(List.of("I")));
    }

    @Test
    void queueTest() {
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("A");
        aList.add("B");

        String node = aList.remove(0);

        log.info("node={}", node);
        log.info("aList={}",aList);
        log.info("aList={}", aList.contains("A"));
    }

    @Test
    @DisplayName("BSFSearch")
    void BSFSearch() {
        // given
        log.info("DFSSearch={}",DFSSearch(graph, "A"));
    }

    ArrayList<String> DFSSearch(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);
        log.info("needVisit = {}", needVisit);
        while(needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() -1);

            if(!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

}
