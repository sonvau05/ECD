package com;

import com.example.HelloBean;
import jakarta.ejb.embeddable.EJBContainer;
import javax.naming.Context;

public class Main {
    public static void main(String[] args) throws Exception {
        try (EJBContainer container = EJBContainer.createEJBContainer()) {
            Context context = container.getContext();

            HelloBean helloBean = (HelloBean) context.lookup("java:global/HelloWorldEJB/HelloBean");
            
            System.out.println("\n-------------------------------------");
            System.out.println(helloBean.sayHello("Anh Em Coder"));
            System.out.println("-------------------------------------\n");
        }
    }
}