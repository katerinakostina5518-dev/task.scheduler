package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatchesSuccess() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual); // Должен вернуть true, так как "Позвонить" входит в название задачи
    }

    @Test
    public void testSimpleTaskMatchesFailed() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual); // Должен вернуть false, так как "Написать" не входит в название задачи
    }

    @Test
    public void testEpicTaskMatchesSuccess() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicTaskMatchesFailed() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Сыр");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTaskMatchesSuccessByTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("приложения");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskMatchesFailedByProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskMatchesFailedFailed() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Вторник");

        Assertions.assertFalse(actual);
    }
}