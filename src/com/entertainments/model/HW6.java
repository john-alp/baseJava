package com.entertainments.model;


    class HW6<T1, T2> {
        T1 object1;
        T2 object2;

        HW6(T1 one, T2 two) {
            object1 = one;
            object2 = two;
        }

        public T1 getFirst() {
            return object1;
        }

        public T2 getSecond() {
            return object2;
        }
    }

    class Test3 {
        public static void main(String[] args) {
            HW6<Integer, String> pair = new HW6<Integer, String>(6,
                    " Apr");
            System.out.println(pair.getFirst() + pair.getSecond());
        }
    }
