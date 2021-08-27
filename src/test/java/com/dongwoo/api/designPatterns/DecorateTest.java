package com.dongwoo.api.designPatterns;

import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DecorateTest {

    @DisplayName("Decoration pattern")
    @Test
    void main() {
        Burger myOrder = new BurgerShop(Burger::addCheese)
            .use(new BurgerShop(Burger::addVeggies)
                .use(new Burger()));

        System.out.println("주문한 내용: " + myOrder);
    }

    class Burger {

        private String burgerType;

        public Burger() {
            this.burgerType = "";
        }

        private Burger(String type) {
            this.burgerType = type;
        }

        public Burger addVeggies() {
            System.out.println("Add veggies");
            return new Burger(this.burgerType += "Veggie ");
        }

        public Burger addCheese() {
            System.out.println("Add cheese");
            return new Burger(this.burgerType += "Cheese ");
        }

        public String toString() {
            return String.format("%s", burgerType + "burger");
        }
    }

    class BurgerShop {

        Function<Burger, Burger> decoration;

        public BurgerShop(Function<Burger, Burger> decoration) {
            this.decoration = decoration;
        }

        public Burger use(Burger burger) {
            System.out.println("Base Burger: " + burger);
            return decoration.apply(burger);
        }
    }

}
