package com.practice.hash;

import com.practice.hash.v2ChainingHash.Hash_V1;
import com.practice.hash.v2LinearHash.Hash_V2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TEst {
    Hash_V1 hash1 = new Hash_V1(20);
    Hash_V2 hash2 = new Hash_V2(20);

    @Test
    @DisplayName("테스트명")
    void 테스트명() {
        int hashLength = hash1.hashTable.length;
        System.out.println("length = " + hashLength);
    }

    @BeforeEach
    void beforeSave() {
//        hash1.saveHash("형기","01071842976");
//        hash1.saveHash("어진","01026018494");
//        hash1.saveHash("어부","01012341234");
//        hash1.saveHash("어뢰","01041233425");

        hash2.saveHashes("형기","01071842976");
        hash2.saveHashes("어진","01026018494");
        hash2.saveHashes("어부","01012341234");
        hash2.saveHashes("어뢰","01041233425");
    }

    @Test
    @DisplayName("세이브 테스트")
    void 세이브_테스트() {
        String 형기 = hash1.getDataFunction("어부");
        System.out.println("어부 = " + 형기);
        Assertions.assertThat(형기).isEqualTo("01012341234");
    }

    @Test
    @DisplayName("세이브 테스트")
    void 세이브_테스트2() {
        String 형기 = hash2.getDataFunction("어부");
        System.out.println("어부 = " + 형기);
        Assertions.assertThat(형기).isEqualTo("01012341234");
    }

    @Test
    @DisplayName("UtilTestHashMap")
    void UtilTestHashMap() {
        HashMap<Integer, String> map2 = new HashMap();
        map2.put(1, "01012341234");
        map2.put(2, "01023452345");
        map2.put(3, "01045671234");

        HashMap<String, String> map3 = new HashMap();
        map3.put("DDDD", "0102341234");

        System.out.println("map3 = " + map3);
    }
}
