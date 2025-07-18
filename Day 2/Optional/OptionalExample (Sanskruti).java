package com.aurionpro.com;

import java.util.Optional;

public class OptionalExample 
{
    public static void main(String[] args) 
    {
        
        Optional<String> name = Optional.of("Sanskruti");
        System.out.println("Name: " + name.get());

        
        Optional<String> nullName = Optional.ofNullable(null);
        System.out.println("Is value present? " + nullName.isPresent());

       
        String result = nullName.orElse("Default");
        System.out.println("Result: " + result); 

        name.ifPresent(n -> System.out.println("Length: " + n.length())); 
        
        
        //Normal
//        String name = getName(); 
//        if (name != null) 
//       {
//           System.out.println(name);
//        }
//        
        
        //Optional
//        Optional<String> name = getName();
//        name.ifPresent(System.out::println);


    }
}
