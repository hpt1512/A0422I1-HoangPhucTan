class Apple {
    weight;

    constructor(weight) {
        this.weight = 10;
    }

    getWeight() {
        return this.weight;
    }
    decrease() {
        this.weight--;
    }
    isEmpty() {
        if(this.weight <= 0) {
            return true;
        }
    }

}

class Human {
    name;
    gender;
    weight;

    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    isMale() {
        return true;
    }
    setGender(gender) {
        this.gender = gender;
    }
    checkApple(apple) {
        if(apple.isEmpty()) {
            console.log('Đã ăn hết táo');
        }
    }
    eat(apple) {
        if(apple.weight > 0) {
            apple.weight--;
            this.weight++;
        }
    }
    say(string) {
        console.log(string);
    }
    getName() {
        return this.name;
    }
    setName(name) {
        this.name = name;
    }
    getWeight() {
        return this.weight;
    }
    setWeight(weight) {
        this.weight = weight;
    }
}

// Main
let apple = new Apple();

let adam = new Human('Adam',true,60);
let eva = new Human('Eva',false,45);


while (apple.getWeight() > 0) {
    adam.eat(apple);
    adam.checkApple(apple);
    eva.eat(apple);
    eva.checkApple(apple);
}

console.log('Khối lượng táo còn lại: '+apple.getWeight());
console.log('Cân nặng của Adam sau khi ăn: '+adam.getWeight());
console.log('Cân nặng của Eva sau khi ăn: '+eva.getWeight());

// adam.say('No rồi');
// eva.say('No rồi');


