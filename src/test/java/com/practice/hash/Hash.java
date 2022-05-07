package com.practice.hash;

public class Hash {
    public Slot[] hashTable;

    public Hash(Integer size) {
        this.hashTable = new Slot[size];
    }

    private static class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0) % this.hashTable.length);
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer adress = this.hashFunc(key);
        if(this.hashTable[adress] != null) {
            return this.hashTable[adress].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
//        String name = "David";
//        char c = name.charAt(0);
//        System.out.println("name = " +c);
//        int c1 = c;
//        System.out.println("c1 = " + c1 % 20);
//
//        final Slot[] slots = new Slot[20];
//        slots[0] = new Slot("test");
//        System.out.println("slots = " + slots[0].value);
        Hash hash = new Hash(20);

        hash.saveData("33333", "01033333333");
        hash.saveData("55555", "01055555555");
        hash.saveData("88888", "01088888888");
        hash.saveData("gkgkgk", "01012341234");
        final String gkgkgk = hash.getData("gkgkgk");
        System.out.println("gkgkgk = " + gkgkgk);
    }
}
