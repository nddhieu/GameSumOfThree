package com.company.deck;

public class Card {
    int number;
    CardName name;
    Type type;

    // constructor
    public Card(int number, Type type) {
        this.number = number;
        this.name = numberToName(number);
        this.type = type;
    }

    public Card(CardName name, Type type) {
        this.name = name;
        this.number = nameToNumber(name);
        this.type = type;
    }

    //constructor without parameter
    public Card() {

    }

    public CardName numberToName(int number) {

        switch (number) {
            case 1:
                return CardName.ONE;
            case 2:
                return CardName.TWO;
            case 3:
                return CardName.THREE;
            case 4:
                return CardName.FOUR;
            case 5:
                return CardName.FIVE;
            case 6:
                return CardName.SIX;
            case 7:
                return CardName.SEVEN;
            case 8:
                return CardName.EIGHT;
            case 9:
                return CardName.NINE;
            case 10:
                return CardName.TEN;
            case 11:
                return CardName.JACK;
            case 12:
                return CardName.QUEEN;
        }
        return CardName.KING;
    }

    public int nameToNumber(CardName name) {
        switch (name.toString()) {
            case "ONE":
                return 1;
            case "TWO":
                return 2;
            case "THREE":
                return 3;
            case "FOUR":
                return 4;
            case "FIVE":
                return 5;
            case "SIX":
                return 6;
            case "SEVEN":
                return 7;
            case "EIGTH":
                return 8;
            case "NINE":
                return 9;
            case "TEN":
                return 10;
            case "JACK":
                return 11;
            case "QUEEN":
                return 12;
        }
        return 13;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.name = numberToName(number);
        this.number = number;
    }

    public CardName getCardNumber() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
