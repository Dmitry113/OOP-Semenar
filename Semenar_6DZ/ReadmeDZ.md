# Применение принципов SOLID в проекте


1. **Single Responsibility Principle (SRP)** - Принцип единственной ответственности
2. **Open/Closed Principle (OCP)** - Принцип открытости/закрытости
3. **Liskov Substitution Principle (LSP)** - Принцип подстановки Лисков
4. **Interface Segregation Principle (ISP)** - Принцип разделения интерфейса
5. **Dependency Inversion Principle (DIP)** - Принцип инверсии зависимостей

## 1. Single Responsibility Principle (SRP)

### Проблема
В текущем коде есть классы, которые занимаются несколькими обязанностями. Например, `StudentGroupService` занимается сортировкой студентов и предоставлением отсортированного списка студентов, что делает его слишком перегруженным.

### Решение
Мы можем разделить `StudentGroupService` на несколько классов, каждый из которых будет выполнять одну задачу.

**Пример до рефакторинга**:
```java
public class StudentGroupService {
    private StudentGroup studentGroup;

    public StudentGroupService(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public List<Student> getSortedStudentById() {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        Collections.sort(studentList);
        return studentList;
    }

    public List<Student> getSortedStudentGroupByFIO() {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        studentList.sort(new UserComparator<Student>());
        return studentList;
    }
}
```

**Рефакторинг**:
1. Создаем отдельные классы для сортировки студентов по ID и ФИО.

```java
public class StudentIdSorter {
    public List<Student> sortById(StudentGroup studentGroup) {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        Collections.sort(studentList);
        return studentList;
    }
}

public class StudentFioSorter {
    public List<Student> sortByFIO(StudentGroup studentGroup) {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        studentList.sort(new UserComparator<Student>());
        return studentList;
    }
}
```

## 2. Open/Closed Principle (OCP)

### Проблема
Если нам нужно добавить новый способ сортировки студентов, нам нужно изменить класс `StudentGroupService`, что нарушает принцип открытости/закрытости.

### Решение
Используем полиморфизм и инъекцию зависимостей для расширения функциональности без изменения существующего кода.

**Пример до рефакторинга**:
```java
public class StudentGroupService {
    // существующий код
}
```

**Рефакторинг**:
1. Интерфейс для сортировки:

```java
public interface StudentSorter {
    List<Student> sort(StudentGroup studentGroup);
}
```

2. Конкретные реализации:

```java
public class StudentIdSorter implements StudentSorter {
    @Override
    public List<Student> sort(StudentGroup studentGroup) {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        Collections.sort(studentList);
        return studentList;
    }
}

public class StudentFioSorter implements StudentSorter {
    @Override
    public List<Student> sort(StudentGroup studentGroup) {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        studentList.sort(new UserComparator<Student>());
        return studentList;
    }
}
```

3. Измененный `StudentGroupService`:

```java
public class StudentGroupService {
    private StudentSorter studentSorter;

    public StudentGroupService(StudentSorter studentSorter) {
        this.studentSorter = studentSorter;
    }

    public List<Student> getSortedStudentGroup(StudentGroup studentGroup) {
        return studentSorter.sort(studentGroup);
    }
}
```

## 3. Liskov Substitution Principle (LSP)

### Проблема
Классы должны быть заменяемыми своими базовыми типами без нарушения функциональности. Например, классы, реализующие интерфейс `UserController`, должны корректно работать при замене конкретными реализациями.

### Решение
Проверяем, что реализации интерфейсов и базовых классов корректно работают с их производными классами.

**Пример до рефакторинга**:
```java
public class StudentController implements UserController<Student> {
    // существующий код
}

public class TeacherController implements UserController<Teacher> {
    // существующий код
}
```

**Рефакторинг**:
1. Убедитесь, что обе реализации интерфейса `UserController` корректно обрабатывают свои типы.

```java
public class StudentController implements UserController<Student> {
    // Код для управления студентами
}

public class TeacherController implements UserController<Teacher> {
    // Код для управления учителями
}
```

## 4. Interface Segregation Principle (ISP)

### Проблема
Интерфейсы должны быть раздельными и не перегруженными методами, которые не используются в конкретных реализациях.

### Решение
Разделяем большие интерфейсы на более узкие и специфичные.

**Пример до рефакторинга**:
```java
public interface UserController<T extends User> {
    void create(String firstName, String secondName, String lastName);
    void sendOnConsole();
}
```

**Рефакторинг**:
1. Разделяем интерфейс на более узкие:

```java
public interface UserCreator<T extends User> {
    void create(String firstName, String secondName, String lastName);
}

public interface UserViewer<T extends User> {
    void sendOnConsole();
}
```

2. Обновляем реализации:

```java
public class StudentController implements UserCreator<Student>, UserViewer<Student> {
    // Реализация методов
}

public class TeacherController implements UserCreator<Teacher>, UserViewer<Teacher> {
    // Реализация методов
}
```

## 5. Dependency Inversion Principle (DIP)

### Проблема
Модули высокого уровня не должны зависеть от модулей низкого уровня. Вместо этого, оба типа модулей должны зависеть от абстракций.

### Решение
Используем абстракции для зависимости между модулями.

**Пример до рефакторинга**:
```java
public class StudentGroupService {
    private StudentGroup studentGroup;

    public StudentGroupService(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
```

**Рефакторинг**:
1. Внедряем зависимость через абстракцию:

```java
public interface StudentGroupProvider {
    StudentGroup getStudentGroup();
}

public class StudentGroupService {
    private StudentGroupProvider studentGroupProvider;

    public StudentGroupService(StudentGroupProvider studentGroupProvider) {
        this.studentGroupProvider = studentGroupProvider;
    }

    public List<Student> getSortedStudentGroup() {
        StudentGroup studentGroup = studentGroupProvider.getStudentGroup();
        // Реализация сортировки
    }
}
```

2. Реализуем `StudentGroupProvider`:

```java
public class ConcreteStudentGroupProvider implements StudentGroupProvider {
    private StudentGroup studentGroup;

    public ConcreteStudentGroupProvider(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public StudentGroup getStudentGroup() {
        return studentGroup;
    }
}
```

Эти изменения помогут улучшить структуру кода, повысить его гибкость и упростить дальнейшую разработку и поддержку.