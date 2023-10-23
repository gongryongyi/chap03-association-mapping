package com.ohgiraffers.section03.persistencecontext;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class A_EntityLifeCycleTests {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 비영속성_테스트() {
        //given
        Menu foundMenu = entityManager.find(Menu.class, 11);
        Menu newMenu = new Menu();
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());
        //when
        boolean isTrue = (foundMenu == newMenu);
        //then
        assertFalse(isTrue);
    }

    @Test
    public void 영속성_연속_조회_테스트() {
        //given
        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 11);
        //when
        boolean isTrue = (foundMenu1 == foundMenu2);
        //then
        assertTrue(isTrue);
    }

    @Test
    public void 영속성_객체_추가_테스트() {
        //given
        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(500);
        menuToRegist.setMenuName("수박죽");
        menuToRegist.setMenuPrice(10000);
        menuToRegist.setCategoryCode(1);
        menuToRegist.setOrderableStatus("Y");
        //when
        entityManager.persist(menuToRegist);
        Menu foundMenu = entityManager.find(Menu.class, 500);
        boolean isTrue = (menuToRegist == foundMenu);
        //then
        assertTrue(isTrue);
    }

    @Test
    public void 영속성_객체_추가_값_변경_테스트() {
        //given
        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(500);
        menuToRegist.setMenuName("수박죽");
        menuToRegist.setMenuPrice(10000);
        menuToRegist.setCategoryCode(1);
        menuToRegist.setOrderableStatus("Y");
        //when
        entityManager.persist(menuToRegist);
        menuToRegist.setMenuName("메론죽");
        Menu foundMenu = entityManager.find(Menu.class, 500);
        //then
        assertEquals("메론죽", foundMenu.getMenuName());
    }












}
