package com.horstmann.ch7;

//В этой главе рекомендовалось пользоваться интерфейсами вместо конкретных
//        классов структур данных, например, интерфейсом Мар вместо класса ТгееМар.
//        К сожалению, подобная рекомендация не идет дальше этого. Почему нельзя,
//        например, воспользоваться интерфейсом Map<String, Set<Integer», чтобы
//        представить содержание документа? (Подсказка: как инициализировать его?)
//        Каким типом структуры данных можно вместо этого воспользоваться?

import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        Map<String, Set<Integer>> map1 = new TreeMap<>();
        for (int i = 0; i < 4; i++) {
            int sz = 0;
            while (sz == 0)
                sz = new Random().nextInt(10);
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < sz; j++) {
                set.add(j);
            }
            map1.put("String " + i, set);
        }


        for (Map.Entry<String, Set<Integer>> stringSetEntry : map1.entrySet()) {
            System.out.println(stringSetEntry);
        }

        /*
        Основная проблема в том, что Map и Set могут быть как упорядоченными
        (TreeMap, TreeSet), так и нет
        Для содержания документа необходимо чтоб и мап, и сет были упорядочены.
        Кроме того необходимо соблюдение иерархии, а у хеш-коллекций она
        отсутствует.
         */
    }
}
