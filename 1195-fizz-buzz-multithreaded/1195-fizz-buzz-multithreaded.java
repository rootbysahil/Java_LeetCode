
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore num = new Semaphore(1);
    private Semaphore f = new Semaphore(0);
    private Semaphore b = new Semaphore(0);
    private Semaphore fb = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                f.acquire();
                printFizz.run();
                num.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                b.acquire();
                printBuzz.run();
                num.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fb.acquire();
            printFizzBuzz.run();
            num.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            num.acquire();

            if (i % 15 == 0) fb.release();
            else if (i % 3 == 0) f.release();
            else if (i % 5 == 0) b.release();
            else {
                printNumber.accept(i);
                num.release();
            }
        }
    }
}
