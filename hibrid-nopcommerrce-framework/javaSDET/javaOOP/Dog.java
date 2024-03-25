package javaOOP;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Dog extends Annimals{ //final : không cho class khác kế thừa
    public static void main(String [] args){
        Dog dog= new Dog();
        System.out.println(dog.annimalAge);
        dog.setAnnimalName("miu miu");
        System.out.println(dog.getAnnimalName());

    }


}
