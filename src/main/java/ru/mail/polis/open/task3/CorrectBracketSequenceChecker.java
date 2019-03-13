package ru.mail.polis.open.task3;

import org.jetbrains.annotations.Nullable;

import java.util.Stack;

/**
 * Для проверки класса на корректность следует использовать тесты.
 * Команда {@code ./gradlew clean build} должна завершаться корректно.
 * <p>
 * При решении задания следует обратить внимание на использование ключевых слов {@code final} и {@code static}
 * <p>
 * В результирующим PR нужно предоставить
 * - Код решения
 * Реализовать все методы
 * Весь код внутри CorrectBracketSequencePredicate
 * Сигнатуры класса, конструктора и метода следует оставить неизменными
 * Комментарии оставить неизменными
 * Можно добавлять дополнительные методы
 * - Тесты
 * Внутри package ru.mail.polis.open.task3
 * В нём будут видны public / protected / package_private методы
 */
public final class CorrectBracketSequenceChecker {

    private CorrectBracketSequenceChecker() {
        /* todo: append code if needed */
    }

    /**
     * Метод проверяющий скобочную последовательность на правильность.
     * <p>
     * Пустая строка
     * — правильная скобочная последовательность.
     * Правильная скобочная последовательность, взятая в скобки одного типа
     * — правильная скобочная последовательность.
     * Правильная скобочная последовательность,
     * к которой слева или справа приписана правильная скобочная последовательность
     * — правильная скобочная последовательность.
     * <p>
     * Последовательности из больше чем ста символов или с символами не скобок — некорректные.
     * <p>
     * Скобки бывают:
     * 1. Круглые '(', ')'
     * 2. Квадратные '[', ']'
     * 3. Фигурные '{', '}'
     *
     * @param sequence — входная строка
     * @return {@code true} — если скобочная последовательность корректна и {@code false} иначе
     * @throws IllegalArgumentException если в строке содержатся символы, не являющиеся скобками
     *                                  или если входная строка содержит больше ста символов
     */
    public static boolean checkSequence(@Nullable String sequence) {

        if (sequence == null) {
            return true;
        }

        if (sequence.length() >  100) {
            throw new IllegalArgumentException("Sequence is more than 100 characters long");
        }

        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {

            if (isOpenBracket(sequence.charAt(i))) {
                charStack.push(sequence.charAt(i));
                continue;
            }

            if (isCloseBracket(sequence.charAt(i))) {
                if (charStack.empty()) {
                    return false;
                }

                if (!charCorrespondsToCharInStack(sequence.charAt(i), charStack.pop())) {
                    return false;
                }
                continue;
            }

            throw new IllegalArgumentException("Sequence contains non-bracket character");
        }

        return charStack.empty();
    }

    private static boolean charCorrespondsToCharInStack(char sequenceChar, char stackChar) {
        switch (stackChar) {
            case '{' : {
                return sequenceChar == '}';
            }

            case '(' : {
                return sequenceChar == ')';
            }

            case '[' : {
                return sequenceChar == ']';
            }

            default: {
                throw new IllegalArgumentException("Stack char is not an open bracket");
            }
        }
    }

    private static boolean isCloseBracket(char c) {
        return (c == ')') || (c == '}') || (c == ']');
    }

    private static boolean isOpenBracket(char c) {
        return (c == '(') || (c == '{') || (c == '[');
    }

    /**
     * Возвращает количество проверок, в результате которых выяснилось,
     * что входная строка является правильной скобочной последовательностью.
     *
     * @return количество удачных проверок
     */
    public static int getSuccessChecksCount() {
        throw new UnsupportedOperationException("todo: implement this");
    }

    /**
     * Возвращает количество проверок, в результате которых выяснилось,
     * что входная строка не является правильной скобочной последовательностью.
     *
     * @return количество неудачных проверок
     */
    public static int getFailChecksCount() {
        throw new UnsupportedOperationException("todo: implement this");
    }

    /**
     * Возвращает последнюю последовательность, проверка которой завершилась успешно.
     *
     * @return последняя правильная скобочная последовательность или null если такой ещё не было
     */
    public static @Nullable String getLastSuccessSequence() {
        throw new UnsupportedOperationException("todo: implement this");
    }
}
