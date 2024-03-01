Spring_1 Intro & Core

Annotation-based configuration and Spring Dependency Injection



1. Підготувати різні POJO класи з анотацією @Component, які розміщені в 3х різних пекеджах:

    beans1 (біни: BeanA, BeanB, BeanC),

    beans2 (біни: RoseFlower, CatAnimal, NarcissusFlower),

    beans3 (біни: BeanD, BeanE, BeanF).

2. Створити 2ва файли конфігурації @Configuration.

3. Перша @Configuration проводить скан компонентів в пекіджі beans1.

4. Друга @Configuration сканує усі компоненти з beans2, а з beans3 вибирає лише BeanD та BeanF.

5. В окремому пекеджі створити біни OtherBeanA, OtherBeanB, OtherBeanC з анотацією @Component.

6. Створити біни, які будуть вприскувати біни з п.5 за допомогою @Autowired в:

    a. конструктор

    b. сеттери

    c. поля

    Для деяких з них використати @Qualifier.

7. Створити декілька бінів, які реалізовують певний інтерфейс. Створити бін,  що буде містити колекцію для створених бінів, які є впорядковані з використанням @Order.

8. Для п.7 один з бінів позначити @Primary, і вприснути ці біни в новий бін як об’єкти цього інтерфейсу, один з них як основний, а решта по @Qualifier.

9. Вивести конфігурацію усіх бінів на екран з використанням ApplicationContext. 