/**
 * Created by nhatnk on 4/26/17.
 */

 function Hero(image,top,left,size,speed) {
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;
  this.speed = speed;

  this.getHeroElement = function () {
    return '<img width="' + this.size + '"' +
        ' height="' + this.size + '"' +
        ' src="' + this.image + '"' +
        ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
  }
  this.moveRight = function () {
    this.left += this.speed;
    console.log('ok: ' + this.left);
  }
  this.moveBottom = function () {
    this.top += this.speed;
    console.log('ok: ' + this.top);
  }
  this.moveLeft = function () {
    this.left -= this.speed;
    console.log('ok: ' + this.left);
  }
  this.moveTop = function () {
    this.top -= this.speed;
    console.log('ok: ' + this.top);
  }
}
var hero = new Hero('pikachu.png', 5, 30, 200, 50);
function start(){
  if(hero.left < window.innerWidth - hero.size && hero.top===5){
    console.log(hero.left);
    hero.moveRight();
  }
  else if(hero.top < window.innerHeight - hero.size && hero.left>window.innerWidth - hero.size){
    hero.moveBottom();
  }else if(hero.left > window.innerWidth - hero.size){
    hero.moveLeft();
  }
  else if(hero.left > 5){
    hero.moveLeft();
  }else {
    hero.moveTop();
  }
  document.getElementById('game').innerHTML = hero.getHeroElement();
  setTimeout(start, 10);
}
start();
// start();