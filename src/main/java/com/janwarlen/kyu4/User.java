package com.janwarlen.kyu4;

// https://www.codewars.com/kata/51fda2d95d6efda45e00004e
public class User {

    public int rank;
    public int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public void incProgress(int rad) {
        if (rad < -8 || rad > 8 || 0 == rad) {
            throw new java.lang.IllegalArgumentException();
        }
        int abs = (this.rank < 0 && rad > 0) ? -1 : 0;
        if (rad == this.rank) {
            this.progress += 3;
        } else if ((this.rank - rad) == 1) {
            this.progress += 1;
        } else if ((this.rank - rad) > 1) {
            if (1 == this.rank && -1 == rad) {
                this.progress += 1;
            }
        } else {
            int d = rad - this.rank + abs;
            this.progress += 10 * d * d;
        }
        if (this.progress >= 100) {
            this.rank += this.progress / 100;
            this.progress %= 100;
            if (this.rank == 0) {
                this.rank += 1;
            }
        }
        if (this.rank == 8) {
            this.rank = 8;
            this.progress = 0;
        }
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.rank); // => -8
        System.out.println(user.progress); // => 0
        user.incProgress(-1);
        System.out.println(user.progress); // => 10
    }
}
