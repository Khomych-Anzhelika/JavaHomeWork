package com.pb.khomich.hw7;
/*Создать пакет hw7 и в нем создать перечисление (enum) Size со значениями XXS, XS, S, M, L.

Перечисление содержит метод getDescription(), возвращающий строку для XXS "Детский размер",
для остальных "Взрослый размер".

Так же перечисление должно иметь метод getEuroSize()
возвращающий числовое значение (32, 34, 36, 38, 40) соответствующее каждому размеру.

Создать конструктор принимающий на вход description и euroSize.
*/

public enum Size {

        XXS(32),
        XS(34),
        S(36),
        M(38),
        L(40);

        private String name;
//
        Size(int) {
            this.name = name;
        }
//
//        @Override
//        public String toString() {
//            return name;
//        }

}
