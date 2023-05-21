package main_classes;

import org.jetbrains.annotations.NotNull;
import speicher.FolgeMitDynArray;
import speicher.Puffer;
import speicher.SchlangeMitEVL;
import speicher.Folge;
import java.util.Iterator;
import java.util.Comparator;

import java.util.Random;

public abstract class GenericUtil {
    public static <T> T gambling(T t1, T t2) {
        Random random = new Random();
        boolean chooseFirst = random.nextBoolean();
        return chooseFirst ? t1 : t2;
    }

    public static <T> Puffer<T> gambling(Puffer<T> p1, Puffer<T> p2) {
        Random random = new Random();
        boolean chooseFirst = random.nextBoolean();
        return chooseFirst ? p1 : p2;
    }

    public static <T> @NotNull SchlangeMitEVL<T> arrayToSchlange(T @NotNull [] array) {
        SchlangeMitEVL<T> schlangeMitEVL = new SchlangeMitEVL<>();
        for (T t : array) {
            schlangeMitEVL.insert(t);
        }
        return schlangeMitEVL;
    }

    public static <T> void printAll(@NotNull Iterable<T> iterable) {
        for (T element : iterable) {
            System.out.println(element);
        }
    }

    public static <T, U> void insertInto(Puffer<T> puffer, U @NotNull [] array) {
        for (U element : array) {
            puffer.insert((T) element);
        }
    }

    public static <T, U> void insertInto(Puffer<T> puffer1, @NotNull Puffer<U> puffer2) {
        T element;
        while ((element = (T) puffer2.remove()) != null) {
            puffer1.insert(element);
        }
    }

    public static <T extends Comparable<T>> @NotNull Folge<T> getMinima(@NotNull Puffer<T> puffer1, @NotNull Puffer<T> puffer2) {
        Folge<T> folge = new FolgeMitDynArray<>();

        Iterator<T> iterator1 = puffer1.iterator();
        Iterator<T> iterator2 = puffer2.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            T element1 = iterator1.next();
            T element2 = iterator2.next();

            if (element1.compareTo(element2) <= 0) {
                folge.insert(element1);
            } else {
                folge.insert(element2);
            }
        }

        while (iterator1.hasNext()) {
            folge.insert(iterator1.next());
        }

        while (iterator2.hasNext()) {
            folge.insert(iterator2.next());
        }
        return folge;
    }

    public static <T> @NotNull Folge<T> getMinima(@NotNull Puffer<T> puffer1, @NotNull Puffer<T> puffer2, Comparator<T> comparator) {
        Folge<T> result = new FolgeMitDynArray<>();

        Iterator<T> iterator1 = puffer1.iterator();
        Iterator<T> iterator2 = puffer2.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            T element1 = iterator1.next();
            T element2 = iterator2.next();

            if (comparator.compare(element1, element2) <= 0) {
                result.insert(element1);
            } else {
                result.insert(element2);
            }
        }

        while (iterator1.hasNext()) {
            result.insert(iterator1.next());
        }

        while (iterator2.hasNext()) {
            result.insert(iterator2.next());
        }

        return result;
    }
}
