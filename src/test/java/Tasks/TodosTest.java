package Tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        // Создание простых задач
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        // Создание сложной задачи (Epic)
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        // Создание задачи-встречи (Meeting)
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        // Создание экземпляра менеджера задач
        Todos todos = new Todos();

        // Добавление задач в менеджер
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Ожидание результатов
        Task[] expected = { simpleTask, epic, meeting };

        // Получение реальных результатов
        Task[] actual = todos.findAll();

        // Проверка равенства списков
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchFewTasks() {
        // Создание простых задач
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        // Создание сложной задачи (Epic)
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        // Создание задачи-встречи (Meeting)
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        // Создание экземпляра менеджера задач
        Todos todos = new Todos();

        // Добавление задач в менеджер
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Ожидание результатов
        Task[] expected = { simpleTask, epic }; // Ждем две задачи, содержащие слово "хлеб"

        // Получение реальных результатов
        Task[] actual = todos.search("Хлеб"); // Здесь возможны проблемы с поиском
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneTasks() {
        // Создание простых задач
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        // Создание сложной задачи (Epic)
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        // Создание задачи-встречи (Meeting)
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        // Создание экземпляра менеджера задач
        Todos todos = new Todos();

        // Добавление задач в менеджер
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Ожидание результатов
        Task[] expected = { meeting };

        // Получение реальных результатов
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchZeroTasks() {
        // Создание простых задач
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        // Создание сложной задачи (Epic)
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        // Создание задачи-встречи (Meeting)
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        // Создание экземпляра менеджера задач
        Todos todos = new Todos();

        // Добавление задач в менеджер
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Ожидание результатов
        Task[] expected = { };

        // Получение реальных результатов
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }
}