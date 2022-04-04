package org.example.homework_lesson4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class AreaTriangleTest {
    private static Logger logger = LoggerFactory.getLogger("AreaTriangleTest");


    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнится 1 раз перед всеми тестами");
        logger.info("info log");
        logger.warn("warn log");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполнится перед каждым тестами");
    }

    @Test
    void areaTriangleTest() {
        double area = AreaTriangle.calcTriangleTest(15, 5);
        Assertions.assertEquals(37.5, area);
    }

    @Test
    void areaTriangleWithNegativeNumberTest() {
        double area2 = AreaTriangle.calcTriangleTest(-5, 5);
        Assertions.assertEquals(37.5, area2);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится 1 раз после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится 1 раз после всех тестов");
    }

}
