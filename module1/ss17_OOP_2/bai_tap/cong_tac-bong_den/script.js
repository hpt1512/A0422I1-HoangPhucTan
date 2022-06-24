class ElectricLamp {
    status;

    constructor(status) {
        this.status = status;
    }

    turnOn() {
        this.status = true;
    }
    turnOff() {
        this.status = false;
    }

}

class SwitchButton {
    status;
    lamp;

    constructor(status, lamp) {
        this.status = status;
        this.lamp = lamp;
    }

    connectToLamp(lamp) {
        this.lamp = lamp;
    }
    switchOff() {
        this.status = false;
        this.lamp.turnOff();
    }
    switchOn() {
        this.status = true;
        this.lamp.turnOn();
    }

}

// Main
let electricLamp = new ElectricLamp(false);
let switchButton = new SwitchButton(false, electricLamp);

switchButton.connectToLamp(electricLamp);

switchButton.switchOn();
// switchButton.switchOff();

if(electricLamp.status == true) {
    console.log('Đã bật đèn');
}
else if(electricLamp.status == false){
    console.log('Đã tắt đèn');
}