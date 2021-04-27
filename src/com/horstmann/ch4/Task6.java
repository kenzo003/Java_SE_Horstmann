package com.horstmann.ch4;

//        Допустим, что в методе Item,equals(), представленном в разделе 4.2.2,
//        используется проверка с помощью операции instanceof. Реализуйте метод
//        Discountedltem.equals() таким образом, чтобы выполнять в нем сравнение
//        только с суперклассом, если его параметр otherObject относится к типу Item ,
//        но с учетом скидки, если эго тип Discountedltem . Продемонстрируйте, что
//        этот метод сохраняет симметричность, но не транзитивность, т.е. способность
//        обнаруживать сочетание товаров по обычной цене и со скидкой, чтобы делать
//        вызовы х.equals(у) и у.equals(z ), но не х.equals(z).

public class Task6 {
    public static void main(String[] args) {

        DiscountItem x = new DiscountItem("item", 1, 2);
        Item y = new Item("item", 1);
        DiscountItem z = new DiscountItem("item", 1, 5);

        System.out.println("x.equals(y) = " + x.equals(y)); // true
        System.out.println("y.equals(z) = " + y.equals(z)); // true
        System.out.println("x.equals(z) = " + x.equals(z)); // false
    }
}

class Item {
    private String description;
    private double price;

    public Item(String aDescription, double aPrice) {
        this.price = aPrice;
        this.description = aDescription;
    }

    @Override
    public boolean equals(Object otherObject) {
        //Быстрая проверка объектов на идентичность
        if (this == otherObject) return true;
        //проверка объекта на null
        if (otherObject == null) return false;
        //если классы не совпадают, они не равны
        if (!(otherObject instanceof Item)) return false;

        Item other = (Item) otherObject;

        return description.equals(other.description) && price == other.price;
    }
}

class DiscountItem extends Item {
    private double discount;

    public DiscountItem(String aDescription, double aPrice, double aDiscount) {
        super(aDescription, aPrice);
        this.discount = aDiscount;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        if (otherObject.getClass() == Item.class) return true;

        DiscountItem other = (DiscountItem) otherObject;
        return discount == other.discount;
    }
}