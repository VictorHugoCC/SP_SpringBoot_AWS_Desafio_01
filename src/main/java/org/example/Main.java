package org.example;

import org.example.UI.MenuPrincipal;

import org.example.util.JPAUtil;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();

        em.close();
    }
}
